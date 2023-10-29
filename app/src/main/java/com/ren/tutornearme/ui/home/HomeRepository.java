package com.ren.tutornearme.ui.home;

import static com.ren.tutornearme.util.Common.TUTOR_LOCATION_REFERENCE;

import androidx.lifecycle.MutableLiveData;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.location.LocationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ren.tutornearme.data.DataOrException;


public class HomeRepository {
    private final FirebaseAuth firebaseAuth;
    private final FirebaseUser currentUser;
    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    //private final DatabaseReference collectionReference = db.getReference(TUTOR_INFO_REFERENCE);
    private final DatabaseReference onlineRef = db.getReference().child(".info/connected");
    private final DatabaseReference tutorLocationRef = db.getReference(TUTOR_LOCATION_REFERENCE);
    private final DatabaseReference currentUserRef;
    private final GeoFire geoFire;


    public HomeRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        currentUserRef = tutorLocationRef.child(getCurrentUser().getUid());
        geoFire = new GeoFire(tutorLocationRef);
    }

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public void removeTutorLocation() {
        geoFire.removeLocation(currentUser.getUid());
    }

    public MutableLiveData<DataOrException<Boolean, Exception>> checkTutorLocationSet(LocationResult locationResult) {
        MutableLiveData<DataOrException<Boolean, Exception>> mutableLiveData = new MutableLiveData<>();
        DataOrException<Boolean, Exception> dataOrException = new DataOrException<>();

        geoFire.setLocation(currentUser.getUid(),
                new GeoLocation(locationResult.getLastLocation().getLatitude(),
                        locationResult.getLastLocation().getLongitude()),
                new GeoFire.CompletionListener() {
                    @Override
                    public void onComplete(String key, DatabaseError error) {
                        if (error != null)
                            dataOrException.exception = error.toException();
                        else
                            dataOrException.data = true;

                        mutableLiveData.postValue(dataOrException);
                    }
                });
        return mutableLiveData;
    }

    public DatabaseReference getOnlineRef() { return onlineRef; }

    public DatabaseReference getCurrentUserRef() { return currentUserRef; }

}
