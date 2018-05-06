package com.example.inquallity.goodform.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.inquallity.goodform.fragment.DayExercisePageFragment;
import com.example.inquallity.goodform.model.ExercisePage;

import java.util.ArrayList;

/**
 * Created by Inquallity on 23-Jan-18.
 */

public class ExercisePagePagerAdapter extends FragmentStatePagerAdapter {

    public static final String KEY_TITLE = "TITLE";
    public final static String KEY_DESCRIPTION = "DESCRIPTION";
    public final static String KEY_IMAGE = "IMAGE";
    private final Context mCtx;
    private ArrayList<ExercisePage> mExercisePages;

    public ExercisePagePagerAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        mCtx = ctx;
    }

    @Override
    public Fragment getItem(int position) {

        ExercisePage exercisePage = mExercisePages.get(position % mExercisePages.size());
        Log.d("OYAEBU", "position [" + position + "] === " +
                "title: [" + mCtx.getString(exercisePage.getTitle()) + "], " +
                "description[" + mCtx.getString(exercisePage.getDescription()) + "]");

        Fragment fragment = new DayExercisePageFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_TITLE, exercisePage.getTitle());
        args.putInt(KEY_DESCRIPTION, exercisePage.getDescription());
        args.putInt(KEY_IMAGE, exercisePage.getImageRes());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return mExercisePages.size() * 3;
    }

    public void setPagesCollection(ArrayList<ExercisePage> exercisePageArrayList) {
        mExercisePages = exercisePageArrayList;
        notifyDataSetChanged();
    }
}
