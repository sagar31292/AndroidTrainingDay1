package com.ncr.fragment.custom_view_example;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.ncr.fragment.R;

public class MyCustomTextView extends TextView {
	public MyCustomTextView(Context context) {
		super(context);
		Typeface face = Typeface.createFromAsset(context.getAssets(), "HelveticaNeue.ttf");
		this.setTextColor(context.getColor(R.color.colorAccent));
		this.setTypeface(face);
	}

	public MyCustomTextView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		this.setTextColor(context.getColor(R.color.colorAccent));
		Typeface face=Typeface.createFromAsset(context.getAssets(), "HelveticaNeue.ttf");
		this.setTypeface(face);
	}

	public MyCustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.setTextColor(context.getColor(R.color.colorAccent));
		Typeface face=Typeface.createFromAsset(context.getAssets(), "HelveticaNeue.ttf");
		this.setTypeface(face);
	}

	public MyCustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		this.setTextColor(context.getColor(R.color.colorAccent));
		Typeface face=Typeface.createFromAsset(context.getAssets(), "HelveticaNeue.ttf");
		this.setTypeface(face);
	}
}
