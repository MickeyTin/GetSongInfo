package com.getsonginfo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLHelper {

	private String url;
	private String responce;

	public HTMLHelper(String url) throws IOException {
		if(url == null){
			throw new NullPointerException(HTMLHelper.class.getName() + "(ctor) url == null");
		}
		this.url = url;
		responce = "";				
		makeRequest();
	}

	//@Ensures({"result != null"})
	public String getResponse(){
		return responce;
	}
	
	private void makeRequest() throws IOException{
		URL url = new URL(this.url);
		URLConnection urlConnection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream()));
		
		String inputLine = "";
		while ((inputLine = in.readLine()) != null){
			responce+=inputLine;
		}			
			
		in.close();		
	}

	/**
	 * 
	 * @param elementAttributes consider elements with these attributes, <code>elementAttributes[0]</code>
	 * @param key attribute name
	 * @return List<{"json","Objects"}>, can be 0 size
	 * @throws ParseException 
	 *///TODO:elementAttributes!=null foreach && size>=1
	public List<String> extractJSONObjects(String elementAttributeStarting,String key) throws ParseException{							
		
		Document doc = Jsoup.parse(getResponse());
		Elements elements = doc.getElementsByAttributeValueStarting(key, elementAttributeStarting);			
		
		List<String> jsonObjects = new ArrayList<String>();
		
		for(Element element:elements){					
			String attVal = element.attr(key);
			int leftBraceIndex = attVal.indexOf('{');
			int rightBraceIndex = attVal.lastIndexOf('}');
						
			if(leftBraceIndex != -1 && rightBraceIndex != -1){
				jsonObjects.add(attVal.substring(leftBraceIndex,rightBraceIndex+1));
				}						
		}
		
		return jsonObjects;		
	}
}
