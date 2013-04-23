import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.getsonginfo.utils.HTMLHelper;
import com.getsonginfo.utils.JSON2MusicInfo;
import com.google.java.contract.Requires;

public class Program {
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParseException 
	 */
	@Requires({"args == null"})
	public static void main(String[] args) throws IOException,
			InterruptedException, ParseException {
		HTMLHelper htmlHelper = new HTMLHelper(
				"http://music.yandex.ua/fragment/search?text=2pac&type=tracks&page=1");
		String resp = htmlHelper.getResponse();
		if(!resp.contains("b-track")){
			System.out.println("No songs");
		}

		List<String> jsonObjects = htmlHelper.extractJSONObjects("return {",
				"onclick");
		for(String jsonObj:jsonObjects){
			JSON2MusicInfo musicInfo = new JSON2MusicInfo(jsonObj);
			if(musicInfo.getMusicInfo() != null){
				System.out.println(
				musicInfo.getMusicInfo()
			.getTrack().getTitle());
			}
		}							
	}
}