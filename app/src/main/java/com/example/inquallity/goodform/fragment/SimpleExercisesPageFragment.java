package com.example.inquallity.goodform.fragment;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inquallity.goodform.R;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Inquallity on 23-Jan-18.
 */

public class SimpleExercisesPageFragment extends Fragment {

    public static final String KEY_TITLE = "TITLE";
    public final static String KEY_DESCRIPTION = "DESCRIPTION";
    public final static String KEY_IMAGE = "IMAGE";

    @BindView(R.id.tv_title) TextView mTitle;
    @BindView(R.id.iv_picture) ImageView mPicture;
    @BindView(R.id.tv_description) TextView mDescription;
    private Unbinder mUnbinder;

    @NonNull
    public static Fragment newInstance(String title, String descr, String imgPath) {
        final Fragment fmt = new SimpleExercisesPageFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putString(KEY_DESCRIPTION, descr);
        args.putString(KEY_IMAGE, imgPath);
        fmt.setArguments(args);
        return fmt;
    }

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
        final String titleRes = args.getString(KEY_TITLE);
        final String descriptionRes = args.getString(KEY_DESCRIPTION);
        mTitle.setText(titleRes);
        mDescription.setText(descriptionRes);
        String imgPath = args.getString(KEY_IMAGE);
        if (!TextUtils.isEmpty(imgPath)) {
            imgPath = imgPath.trim();
            final AssetManager assets = getActivity().getAssets();
            try {
                final InputStream is = assets.open(imgPath);
                final Bitmap bmp = BitmapFactory.decodeStream(is);
                mPicture.setImageBitmap(bmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
