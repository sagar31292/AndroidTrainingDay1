package com.ncr.fragment.retrofit_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.ncr.fragment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomViewHolder> {

	private List<TestResponse> dataList;
	private Context context;

	public DataAdapter(Context context,List<TestResponse> dataList){
		this.context = context;
		this.dataList = dataList;
	}

	class CustomViewHolder extends RecyclerView.ViewHolder {

		public final View mView;

		TextView txtTitle;
		private ImageView coverImage;

		CustomViewHolder(View itemView) {
			super(itemView);
			mView = itemView;

			txtTitle = mView.findViewById(R.id.title);
			coverImage = mView.findViewById(R.id.coverImage);
		}
	}

	@Override
	public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
		return new CustomViewHolder(view);
	}

	@Override
	public void onBindViewHolder(CustomViewHolder holder, int position) {
		holder.txtTitle.setText(dataList.get(position).getTitle());

		Picasso.Builder builder = new Picasso.Builder(context);
		builder.downloader(new OkHttp3Downloader(context));
		builder.build().load(dataList.get(position).getThumbnailUrl())
				.placeholder((R.drawable.ic_launcher_background))
				.error(R.drawable.ic_launcher_background)
				.into(holder.coverImage);

	}

	@Override
	public int getItemCount() {
		return dataList.size();
	}
}