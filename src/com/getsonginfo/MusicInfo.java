package com.getsonginfo;

public class MusicInfo {

	private Album album;
	private Artist artist;
	private Track track;
	
	public MusicInfo(Album album, Artist artist, Track track) {		
		this.album = album;
		this.artist = artist;
		this.track = track;
	}

	public Album getAlbum() {
		return album;
	}

	public Artist getArtist() {
		return artist;
	}

	public Track getTrack() {
		return track;
	}		
	
}
