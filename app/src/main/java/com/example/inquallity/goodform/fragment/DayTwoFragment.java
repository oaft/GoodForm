package com.example.inquallity.goodform.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inquallity.goodform.R;
import com.example.inquallity.goodform.adapter.ExercisePagePagerAdapter;
import com.example.inquallity.goodform.model.ExercisePage;
import com.example.inquallity.goodform.repo.PrefsManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Olga Aleksandrova on 19-Jan-18.
 */

public class DayTwoFragment extends Fragment {

    private ArrayList<ExercisePage> mExercisePageArrayList = new ArrayList<>(5);
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

        for (int i = 1; i <= 5; i++) {
            ExercisePage exercisePage = chooseResource(i);
            mExercisePageArrayList.add(exercisePage);
        }

        ExercisePagePagerAdapter exercisePagePagerAdapter = new ExercisePagePagerAdapter(getActivity(), getChildFragmentManager());
        exercisePagePagerAdapter.setPagesCollection(mExercisePageArrayList);
        mViewPager.setAdapter(exercisePagePagerAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    private ExercisePage chooseResource(int count) {
        int resTitle;
        int resDescription;
        int resImage;

        switch (count) {
            case 1:
                resTitle = R.string.title_2_1;
                resDescription = R.string.description_2_1;
                resImage = R.drawable.podem_nog_lezha_2_1;
                break;
            case 2:
                resTitle = R.string.title_2_2;
                resDescription = R.string.description_2_2;
                resImage = R.drawable.diag_vypad_s_gantelami_2_2;
                break;
            case 3:
                resTitle = R.string.title_2_3;
                resDescription = R.string.description_2_3;
                resImage = R.drawable.razvodka_ganteley_lega_2_3;
                break;
            case 4:
                resTitle = R.string.title_2_4;
                resDescription = R.string.description_2_4;
                resImage = R.drawable.tyaga_ganteli_v_naklone_2_4;
                break;
            case 5:
                resTitle = R.string.title_2_5;
                resDescription = R.string.description_2_5;
                resImage = R.drawable.zhim_ganteley_sidya_2_6;
                break;
            default:
                resTitle = R.string.title_2_1;
                resDescription = R.string.description_2_1;
                resImage = R.drawable.podem_nog_lezha_2_1;
                break;
        }

        final ExercisePage exercisePage = new ExercisePage();
        exercisePage.setTitle(resTitle);
        exercisePage.setImageRes(resImage);
        exercisePage.setDescription(resDescription);

        return exercisePage;
    }
}
