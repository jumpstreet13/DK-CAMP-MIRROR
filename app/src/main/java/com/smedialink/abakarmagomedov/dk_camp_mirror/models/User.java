package com.smedialink.abakarmagomedov.dk_camp_mirror.models;

import com.google.gson.annotations.SerializedName;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class User {

    @SerializedName("Id")
    private long id;

    @SerializedName("FirstName")
    private String firstName;

    @SerializedName("LastName")
    private String secondName;

    @SerializedName("Email")
    private String email;

    @SerializedName("AddressLine1")
    private String addresslineOne;

    @SerializedName("AddressLine2")
    private String addresslineTwo;

    @SerializedName("PostNumber")
    private String postNumber;

    @SerializedName("MobileNumber")
    private String mobileNumber;

    @SerializedName("ProfilePictureUrl")
    private String profilePictureUrl;

    @SerializedName("Birthday")
    private Date birthday;

    @SerializedName("MembershipEndDate")
    private Date membershipDate;

    @SerializedName("MembershipId")
    private String membershipId;

    @SerializedName("MembershipCardUrl")
    private String membershipCardUrl;

    @SerializedName("InterestOptions")
    private List<String> interests;

    @SerializedName("CampingAsOptions")
    private List<String> campingAsOption;

    @SerializedName("AccomodationOptions")
    private List<String> accomondations;

    @SerializedName("CampingExperience")
    private Integer campingExperience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        if (firstName == null) return "";
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        if (secondName == null) return "";
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        if (email == null) return "";
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresslineOne() {
        if (addresslineOne == null) return "";
        return addresslineOne;
    }

    public void setAddresslineOne(String addresslineOne) {
        this.addresslineOne = addresslineOne;
    }

    public String getAddresslineTwo() {
        if (addresslineTwo == null || addresslineTwo.isEmpty()) return "";
        return ", " + addresslineTwo;
    }

    public void setAddresslineTwo(String addresslineTwo) {
        this.addresslineTwo = addresslineTwo;
    }

    public String getPostNumber() {
        if (postNumber == null) return "";
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public String getMobileNumber() {
        if (mobileNumber == null) return "";
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getProfilePictureUrl() {
        if (profilePictureUrl == null) profilePictureUrl = "";
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthdayString() {
        if (this.birthday == null) return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.birthday);
        return
                calendar.get(Calendar.DAY_OF_MONTH)+" : " +
                calendar.get(Calendar.MONTH)+" : " +
                calendar.get(Calendar.YEAR);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public String getMembershipDateString() {
        if (this.membershipDate == null) return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.membershipDate);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH))
                .concat("-")
                .concat(String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.MONTH)))
                .concat("-")
                .concat(String.format(Locale.getDefault(), "%02d", calendar.get(Calendar.YEAR)));
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getMembershipId() {
        if (membershipId == null) return "";
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipCardUrl() {
        if(membershipCardUrl == null) return "";
        return membershipCardUrl;
    }

    public void setMembershipCardUrl(String membershipCardUrl) {
        this.membershipCardUrl = membershipCardUrl;
    }

    public List<String> getInterests() {
        if (interests == null) return new ArrayList<>();
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getAccomondations() {
        if (accomondations == null) return new ArrayList<>();
        return accomondations;
    }

    public void setAccomondations(List<String> accomondations) {
        this.accomondations = accomondations;
    }

    public Integer getCampingExperience() {
        if (campingExperience == null) return 0;
        return campingExperience;
    }

    public void setCampingExperience(Integer campingExperience) {
        this.campingExperience = campingExperience;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getSecondName();
    }


    private static Map<String, Integer> campingOptions;
    static {
        campingOptions = new HashMap<>();
        campingOptions.put("CoupleWithChildren", R.string.familie);
        campingOptions.put("Couple", R.string.uden_b_rn);
        campingOptions.put("Single", R.string.single);
        campingOptions.put("Senior", R.string.senior);
    }

    public Integer getCampingOptions() {
        String key = "Couple";
        if (campingAsOption != null && !campingAsOption.isEmpty()){
            key = campingAsOption.get(0);
        }
        return campingOptions.get(key) == null ? R.string.familie : campingOptions.get(key);
    }

}
