package com.ncr.fragment.retrofit_example;

import com.google.gson.annotations.SerializedName;

public class TestResponse {

	@SerializedName("albumId")
	private Integer albumIdTest;
	@SerializedName("id")
	private Integer id;
	@SerializedName("title")
	private String title;
	@SerializedName("url")
	private String url;
	@SerializedName("thumbnailUrl")
	private String thumbnailUrl;

	public TestResponse(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
		this.albumIdTest = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	public Integer getAlbumId() {
		return albumIdTest;
	}

	public void setAlbumId(Integer albumId) {
		this.albumIdTest = albumId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
}