package com.getsonginfo.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.getsonginfo.Album;
import com.getsonginfo.Artist;
import com.getsonginfo.MusicInfo;
import com.getsonginfo.Track;
import com.google.java.contract.Requires;

public class JSON2MusicInfo {

	private MusicInfo musicInfo;
	private String jsonString;
	
	@Requires({"jsonString == null"})
	public JSON2MusicInfo(String jsonString) throws ParseException {
	
		if(jsonString == null){
			throw new NullPointerException("JSON2MusicInfo(ctor)->jsonString == null");
		}
			
		this.jsonString = jsonString;
		
		musicInfo = convertJson2MusicInfo();

	}
	
	public MusicInfo getMusicInfo(){return musicInfo;}
	
	private MusicInfo convertJson2MusicInfo() throws ParseException{
		
		try {

			JSONParser parser = new JSONParser();
			JSONObject jObj = (JSONObject) parser.parse(jsonString);

			Track track = new Track((String) jObj.get("id"),
					(String) jObj.get("storage_dir"),
					(String) jObj.get("title"), Long.valueOf((String) jObj
							.get("duration")));

			Artist artist = new Artist((String) jObj.get("artist_id"),
					(String) jObj.get("artist"));

			Album album = new Album((String) jObj.get("album_id"),
					(String) jObj.get("album"), (String) jObj.get("cover"));

			return new MusicInfo(album, artist, track);
		} catch (Throwable e) {
			
		}
		return null;
	}
}
