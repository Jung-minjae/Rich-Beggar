package Ju.KP;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jusic_Detail {

	public Detail_DTO getCode() {

		Detail_DTO CD = new Detail_DTO();

		try {
			String url = "https://finance.naver.com/sise/sise_rise.nhn?sosok=0";

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

			CD = new Detail_DTO(list1);

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return CD;
	}

}
