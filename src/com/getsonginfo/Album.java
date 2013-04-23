package com.getsonginfo;

public class Album {

	private String id;
	private String title;
	private String coverURL;
	
	public Album(String id, String title, String coverURL) {		
		this.id = id;
		this.title = title;
		this.coverURL = coverURL;
	}
	
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCoverURL() {
		return coverURL;
	}	
}