package com.example.inquallity.goodform.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Inquallity on 27-Apr-18.
 */

public class SimpleExercisesPage {

    @SerializedName("title") private String mTitle;
    @SerializedName("description") private String mDescription;
    @SerializedName("image_url") private String mImageUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public SimpleExercisesPage(String title, String description, String imageUrl) {
        mTitle = title;
        mDescription = description;
        mImageUrl = imageUrl;
    }
}
