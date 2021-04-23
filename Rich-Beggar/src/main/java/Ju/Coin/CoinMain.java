package Ju.Coin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class CoinMain {

	public static void main(String[] args) throws IOException {
		String url = "https://api.korbit.co.kr/v1/ticker/detailed/all"; 

		CoinDTO Ci = new CoinDTO();
		Document doc = Jsoup.connect(url).ignoreContentType(true).get();
		ArrayList<String> last = new ArrayList<>();
		ArrayList<String> changePercent = new ArrayList<>();
		ArrayList<String> coinname = new ArrayList<>();

	
		JSONParser jsonParser1 = new JSONParser();
        JSONObject jsonObject1;
  
 
		try {
		      jsonObject1 = (JSONObject) jsonParser1.parse(doc.text());
		      Set key = jsonObject1.keySet();
		      
		      Iterator<String> iter =key.iterator();
		      while(iter.hasNext()) {
		    	  String Keyname = iter.next();
    	  
		    	  coinname.add(Keyname);
		    	  System.out.println(Keyname);
		      }
		      
		      for(int i =0; i<coinname.size(); i++) {
		      JSONObject jsonObject2 = (JSONObject) jsonObject1.get(coinname.get(i));
	
		      String last_ = jsonObject2.get("last").toString();
		      String changePercent_ =jsonObject2.get("changePercent").toString();
	             
		         System.out.println(last+"\t"+changePercent+"%");
	            
	            last.add(last_);
	            changePercent.add(changePercent_);

		      }	      
		}
		catch(ParseException e){
			 e.printStackTrace();
			
		}

}
}
