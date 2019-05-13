package com.example.myrestaurant.models;

import java.util.ArrayList;

public class Restaurant {

    private String mName;
    private String mPhone;
    private String mWebsite;
    private double mRating;
    private String mImageUrl;
    private ArrayList<String> mAddress = new ArrayList<>();
    private double mLatitude;
    private double mLongitude;
    private ArrayList<String> mCategories = new ArrayList<>();

    public Restaurant(String mName, String mPhone, String mWebsite, double mRating, String mImageUrl, ArrayList<String> mAddress, double mLatitude, double mLongitude, ArrayList<String> mCategories) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mWebsite = mWebsite;
        this.mRating = mRating;
        this.mImageUrl = mImageUrl;
        this.mAddress = mAddress;
        this.mLatitude = mLatitude;
        this.mLongitude = mLongitude;
        this.mCategories = mCategories;
    }

    public String getmName() {
        return mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public double getmRating() {
        return mRating;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public ArrayList<String> getmAddress() {
        return mAddress;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public ArrayList<String> getmCategories() {
        return mCategories;
    }
}
