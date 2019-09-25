package com.ncr.fragment.fragment_examples.dynamic_binding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ncr.fragment.R;

public class DynamicBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_binding_activity);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.holder_red, com.ncr.fragment.fragment_examples.fragments.RedFragment.newInstance())
                .commitNow();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.holder_blue, com.ncr.fragment.fragment_examples.fragments.BlueFragment.newInstance())
                .commitNow();

    }
}
