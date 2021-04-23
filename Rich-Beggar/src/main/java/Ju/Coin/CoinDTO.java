package Ju.Coin;

import java.util.ArrayList;

public class CoinDTO {
	ArrayList<String> coinname = new ArrayList<>();
	ArrayList<String> last = new ArrayList<>();
	ArrayList<String> changePercent = new ArrayList<>();
	String kr_name[] = { "비트코인캐시", "유니스왑", "트론", "스텔라루멘", "랩트비트코인", "질리카", "폴카닷", "다이", "메이커", "유에스디코인", "오미세고", "체인링크",
			"비트코인캐시에이비씨", "페치", "이더리움클래식", "이더리움", "퀀텀", "카르다노", "리플", "테조스", "바이낸스코인", "아르고", "메디블록", "비트코인", "연파이낸스",
			"이오스", "알고랜드", "비트코인sv", "파일코인", "베이직어텐션토큰", "라이트코인" };

	public CoinDTO(ArrayList<String> coinname, ArrayList<String> last, ArrayList<String> changePercent) {

		this.coinname = coinname;
		this.last = last;
		this.changePercent = changePercent;

	}

	public String getKr_name(int i) {
		return kr_name[i];
	}

	public void setKr_name(String[] kr_name) {
		this.kr_name = kr_name;
	}

	public CoinDTO() {

	}

	public ArrayList<String> getLast() {
		return last;
	}

	public void setLast(ArrayList<String> last) {
		this.last = last;
	}

	public ArrayList<String> getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(ArrayList<String> changePercent) {
		this.changePercent = changePercent;
	}

	public ArrayList<String> getCoinname() {
		return coinname;
	}

	public void setCoinname(ArrayList<String> coinname) {
		this.coinname = coinname;
	}

}
