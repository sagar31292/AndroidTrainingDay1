package com.ncr.fragment.recycler_view_example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ncr.fragment.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
	private ArrayList<String> mDataset;

	static class MyViewHolder extends RecyclerView.ViewHolder {
		View view;

		MyViewHolder(View v) {
			super(v);
			view = v;
		}
	}

	RecyclerViewAdapter(ArrayList<String> myDataset) {
		mDataset = myDataset;
	}

	@Override
	public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
	                                                           int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.single_item, parent, false);

		return new MyViewHolder(v);
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		((TextView) holder.view.findViewById(R.id.textView)).setText(mDataset.get(position));
	}

	@Override
	public int getItemCount() {
		return mDataset.size();
	}
}