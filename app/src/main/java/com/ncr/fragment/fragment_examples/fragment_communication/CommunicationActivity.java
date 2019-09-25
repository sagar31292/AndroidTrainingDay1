package com.ncr.fragment.fragment_examples.fragment_communication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ncr.fragment.R;
import com.ncr.fragment.fragment_examples.fragments.BlueFragment;
import com.ncr.fragment.fragment_examples.fragments.RedFragment;

public class CommunicationActivity extends AppCompatActivity implements RedFragment.OnButtonClickListener {

	private RedFragment redFragment;
	private BlueFragment blueFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.communication_activity);
	}

	@Override
	public void buttonClicked(String message) {
		View v = blueFragment.getView();
		v.findViewById(R.id.holder_blue).setBackgroundColor(getColor(R.color.colorPrimaryDark));
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		if (fragment instanceof RedFragment) {
			redFragment = (RedFragment) fragment;
			redFragment.setListener(this);
		}
		if (fragment instanceof BlueFragment) {
			blueFragment = (BlueFragment) fragment;
		}
	}
}
