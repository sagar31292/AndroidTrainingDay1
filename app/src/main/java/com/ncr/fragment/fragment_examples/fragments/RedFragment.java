package com.ncr.fragment.fragment_examples.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ncr.fragment.R;

public class RedFragment extends Fragment {

    private OnButtonClickListener callback;

    public static RedFragment newInstance() {
        return new RedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.red_fragment, container, false);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.buttonClicked("This message is from Red Fragment");
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void setListener(OnButtonClickListener callback) {
        this.callback = callback;
    }

    public interface OnButtonClickListener {
        void buttonClicked(String message);
    }

}
