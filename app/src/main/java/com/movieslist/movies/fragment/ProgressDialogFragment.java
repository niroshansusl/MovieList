package com.movieslist.movies.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.movieslist.movies.R;

/**
 * Created by niroshan on 8/29/2017.
 */

public class ProgressDialogFragment extends DialogFragment implements View.OnClickListener {

    RelativeLayout rlProgress;

    @NonNull
    public static ProgressDialogFragment newInstance() {
        return new ProgressDialogFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_progress:
                getDialog().dismiss();
                break;
            default:
                break;

        }
        this.dismiss();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Translucent);
        setCancelable(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_progress, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rlProgress = (RelativeLayout) view.findViewById(R.id.rl_progress);
        rlProgress.setOnClickListener(this);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (getProgressDialogFragmentListener() != null) {
            getProgressDialogFragmentListener().onProgressCancelled();
        }
    }

    private ProgressDialogFragmentListener getProgressDialogFragmentListener() {
        if (getActivity() == null) {
            return null;
        }

        if (getActivity() instanceof ProgressDialogFragmentListener) {
            return (ProgressDialogFragmentListener) getActivity();
        }
        return null;
    }

    public interface ProgressDialogFragmentListener {
        void onProgressCancelled();
    }
}

