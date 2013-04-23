package com.getsonginfo;

public class Track {

	private String id;
	private String storageDir;
	private String title;
	private long duration;//ms
	
	public Track(String id, String storageDir, String title, long duration) {
		this.id = id;
		this.storageDir = storageDir;
		this.title = title;
		this.duration = duration;
	}
	public String getId() {
		return id;
	}
	public String getStorageDir() {
		return storageDir;
	}
	public String getTitle() {
		return title;
	}
	public long getDuration() {
		return duration;
	}
	
}