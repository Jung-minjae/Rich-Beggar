package Ju.KD;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JusicKP_Detail {

	public DetailKP_DTO getCode() {

		DetailKP_DTO CD = new DetailKP_DTO();

		try {
			String url = "https://finance.naver.com/sise/sise_rise.nhn?sosok=1";

			Document doc = Jsoup.connect(url).get();
			ArrayList<String> list1 = new ArrayList<>();

			Elements element = doc.select("#contentarea > div.box_type_l > table > tbody > tr td a");
			for (Element a : element) {
//					System.out.println(a);

				String s = a.attr("href");

				String code = s.substring(20, 26);

//				System.out.println(code);

				list1.add(code);
			}

			CD = new DetailKP_DTO(list1);

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return CD;
	}

}
