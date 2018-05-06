package com.example.inquallity.goodform.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.goodform.R;
import com.example.inquallity.goodform.adapter.ExercisePagePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Olga Aleksandrova on 23-Jan-18.
 */

public class DayExercisePageFragment extends Fragment {

    @BindView(R.id.tv_title) TextView mTitle;
    @BindView(R.id.iv_picture) ImageView mPicture;
    @BindView(R.id.tv_description) TextView mDescription;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_description_exercise, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        final int titleRes = args.getInt(ExercisePagePagerAdapter.KEY_TITLE);
        final int descrRes = args.getInt(ExercisePagePagerAdapter.KEY_DESCRIPTION);
        if (titleRes > 0) {
            mTitle.setText(getString(titleRes));
        }
        if (descrRes > 0) {
            mDescription.setText(getString(descrRes));
        }
        mPicture.setImageResource(args.getInt(ExercisePagePagerAdapter.KEY_IMAGE));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
