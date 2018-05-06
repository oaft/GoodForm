package com.example.inquallity.goodform.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.inquallity.goodform.fragment.SimpleExercisesPageFragment;
import com.example.inquallity.goodform.model.SimpleExercisesPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inquallity on 27-Apr-18.
 */

public class SimpleExercisesPageAdapter extends FragmentStatePagerAdapter {

    private List<SimpleExercisesPage> mSimpleExercisesPages = new ArrayList<>();

    public SimpleExercisesPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        SimpleExercisesPage simpleExercisesPage = mSimpleExercisesPages.get(position % mSimpleExercisesPages.size());

        final String title = simpleExercisesPage.getTitle();
        final String description = simpleExercisesPage.getDescription();
        final String imgPath = simpleExercisesPage.getImageUrl();
        return SimpleExercisesPageFragment.newInstance(title, description, imgPath);
    }

    @Override
    public int getCount() {
        return mSimpleExercisesPages.size();
    }

    public void setPagesCollection(List<SimpleExercisesPage> simpleExercisesPages) {
        mSimpleExercisesPages = simpleExercisesPages;
        notifyDataSetChanged();
    }
}
