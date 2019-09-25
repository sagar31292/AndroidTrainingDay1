package com.ncr.fragment.retrofit_example;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ncr.fragment.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
	private DataAdapter adapter;
	private RecyclerView recyclerView;
	ProgressDialog progressDoalog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retrofit);

		progressDoalog = new ProgressDialog(this);
		progressDoalog.setMessage("Loading....");
		progressDoalog.show();

		/*Create handle for the RetrofitInstance interface*/
		EndPoint service = Client.getRetrofitInstance().create(EndPoint.class);
		Call<List<TestResponse>> call = service.getAllPhotos();
		call.enqueue(new Callback<List<TestResponse>>() {
			@Override
			public void onResponse(Call<List<TestResponse>> call, Response<List<TestResponse>> response) {
				progressDoalog.dismiss();
				generateDataList(response.body());
			}

			@Override
			public void onFailure(Call<List<TestResponse>> call, Throwable t) {
				progressDoalog.dismiss();
				Toast.makeText(RetrofitActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
			}
		});
	}

	/*Method to generate List of data using RecyclerView with custom adapter*/
	private void generateDataList(List<TestResponse> photoList) {
		recyclerView = findViewById(R.id.recyclerView);
		adapter = new DataAdapter(this,photoList);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RetrofitActivity.this);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
	}
}
