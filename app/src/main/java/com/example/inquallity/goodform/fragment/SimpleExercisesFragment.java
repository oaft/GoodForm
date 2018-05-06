package com.example.inquallity.goodform.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.goodform.R;
import com.example.inquallity.goodform.adapter.SimpleExercisesPageAdapter;
import com.example.inquallity.goodform.model.SimpleExercisesPage;
import com.example.inquallity.goodform.repo.PrefsManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Inquallity on 27-Apr-18.
 */

public class SimpleExercisesFragment extends Fragment {

    @BindView(R.id.pager) ViewPager mViewPager;
    private Unbinder mUnbinder;
    private PrefsManager mPrefsManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_day, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

        mPrefsManager = new PrefsManager(getActivity());

        if (savedInstanceState == null) {
            if (mPrefsManager.shouldShowNavTips()) {
                SwipeDialogFragment swipeDialogFragment = new SwipeDialogFragment();
                FragmentManager fragmentManager = getFragmentManager();
                swipeDialogFragment.show(fragmentManager, "dialog");
            }
        }

        final List<SimpleExercisesPage> simpleExercisesPage = loadFromAsset();

        SimpleExercisesPageAdapter exercisePageAdapter = new SimpleExercisesPageAdapter(getFragmentManager());
        exercisePageAdapter.setPagesCollection(simpleExercisesPage);
        mViewPager.setAdapter(exercisePageAdapter);
    }

    @NonNull
    private List<SimpleExercisesPage> loadFromAsset() {
        final String path = "exercises/exercises.json";
        try {
            final InputStream is = getActivity().getAssets().open(path);
            final Gson gson = new Gson();
            final InputStreamReader isr = new InputStreamReader(is);
            return gson.fromJson(isr, new TypeToken<List<SimpleExercisesPage>>() {
            }.getType());
        } catch (IOException e) {
            Log.e("ERROR_LOG", e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
