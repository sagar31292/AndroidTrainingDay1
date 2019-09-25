package com.ncr.fragment.recycler_view_example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ncr.fragment.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler_view);

		RecyclerView recyclerView = findViewById(R.id.recyclerView);

		recyclerView.setHasFixedSize(true);

		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Test 1");
		arrayList.add("Test 2");
		arrayList.add("Test 3");
		arrayList.add("Test 4");
		arrayList.add("Test 5");
		arrayList.add("Test 6");
		arrayList.add("Test 7");
		arrayList.add("Test 8");
		arrayList.add("Test 9");

		RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(arrayList);
		recyclerView.setAdapter(mAdapter);
	}
}
