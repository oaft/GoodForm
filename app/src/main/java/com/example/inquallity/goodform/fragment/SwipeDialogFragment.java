package com.example.inquallity.goodform.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import com.example.inquallity.goodform.R;
import com.example.inquallity.goodform.repo.PrefsManager;

/**
 * Created by Olga Aleksandrova on 24-Jan-18.
 */

public class SwipeDialogFragment extends DialogFragment {

    private CheckBox mDoNotShowAgain;
    private PrefsManager mPrefsManager;

    @NonNull
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.fmt_swipe_dialog, null);

        mPrefsManager = new PrefsManager(getActivity());
        mDoNotShowAgain = view.findViewById(R.id.cb_do_not_show_again);
        builder.setView(view)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mPrefsManager.editPreferences(!mDoNotShowAgain.isChecked());
                    }
                });
        return builder.create();
    }
}
