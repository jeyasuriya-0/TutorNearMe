package com.ren.tutornearme.model;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.Map;

@Parcel(Parcel.Serialization.BEAN)
public class TutorInfo {
    private String uid;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String address;
    private long birthDate;
    private String resume;
    private String validId;
    private String validIdType;
    private String avatar;
    private boolean isVerified;
    private long createdDate;
    private long updatedDate;

    public TutorInfo() {
    }

    public TutorInfo(String uid, String firstName, String lastName, String gender, String phoneNumber,
                     String address, long birthDate, String resume, String validId, String validIdType,
                     String avatar, boolean isVerified, long createdDate, long updatedDate) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthDate = birthDate;
        this.resume = resume;
        this.validId = validId;
        this.validIdType = validIdType;
        this.avatar = avatar;
        this.isVerified = isVerified;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getValidId() {
        return validId;
    }

    public void setValidId(String validId) {
        this.validId = validId;
    }

    public String getValidIdType() {
        return validIdType;
    }

    public void setValidIdType(String validIdType) {
        this.validIdType = validIdType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("firstName", firstName);
        result.put("lastName", lastName);
        result.put("gender", gender);
        result.put("birthDate", birthDate);
        result.put("address", address);
        result.put("updatedDate", updatedDate);

        return result;
    }

    @Override
    public String toString() {
        return "TutorInfo{" +
                "uid='" + uid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", resume='" + resume + '\'' +
                ", validId='" + validId + '\'' +
                ", validIdType='" + validIdType + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isVerified=" + isVerified +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
