package com.ncr.fragment.retrofit_example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoint {
	@GET("/photos")
	Call<List<TestResponse>> getAllPhotos();
}
