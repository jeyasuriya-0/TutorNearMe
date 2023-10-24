package com.ren.tutornearme.profile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ren.tutornearme.data.DataOrException;
import com.ren.tutornearme.model.TutorInfo;

import static com.ren.tutornearme.util.Common.TUTOR_INFO_REFERENCE;

import androidx.lifecycle.MutableLiveData;

public class ProfileRepository {
    private final FirebaseAuth firebaseAuth;
    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    private final DatabaseReference collectionReference = db.getReference(TUTOR_INFO_REFERENCE);

    public ProfileRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }

    public MutableLiveData<DataOrException<Boolean, Exception>> registerTutor(TutorInfo tutorInfo) {
        MutableLiveData<DataOrException<Boolean, Exception>> mutableLiveData = new MutableLiveData<>();

        if (getCurrentUser() != null) {
            DataOrException<Boolean, Exception> dataOrException = new DataOrException<>();
            collectionReference.child(getCurrentUser().getUid()).setValue(tutorInfo)
                .addOnCompleteListener(documentReference -> {
                    if (documentReference.isSuccessful()) {
                        dataOrException.data = true;
                    } else {
                        dataOrException.exception = documentReference.getException();
                    }
                    mutableLiveData.postValue(dataOrException);
                });
        }
        return mutableLiveData;
    }
}
