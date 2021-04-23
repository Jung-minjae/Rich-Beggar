package Ju.Coin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CoinDao {

	public CoinDTO getcoin() {
		CoinDTO cd = new CoinDTO();

		String url = "https://api.korbit.co.kr/v1/ticker/detailed/all";
		JSONParser jsonParser1 = new JSONParser();
		JSONObject jsonObject1;

		ArrayList<String> last = new ArrayList<>();
		ArrayList<String> changePercent = new ArrayList<>();
		ArrayList<String> coinname = new ArrayList<>();

				
 		try {
			Document doc = Jsoup.connect(url).ignoreContentType(true).get();

			jsonObject1 = (JSONObject) jsonParser1.parse(doc.text());
			Set key = jsonObject1.keySet();

			Iterator<String> iter = key.iterator();
			while (iter.hasNext()) {
				String Keyname = iter.next();

				coinname.add(Keyname);

			}
			System.out.println(coinname.get(0));

			for (int i = 0; i < coinname.size(); i++) {
				JSONObject jsonObject2 = (JSONObject) jsonObject1.get(coinname.get(i));

				String last_ = jsonObject2.get("last").toString();
				String changePercent_ = jsonObject2.get("changePercent").toString();

//		         System.out.println(last+"\t"+changePercent+"%");

				last.add(last_);
				changePercent.add(changePercent_);

			}
			cd = new CoinDTO(coinname, last, changePercent);
			System.out.println(changePercent.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cd;
	}
}
