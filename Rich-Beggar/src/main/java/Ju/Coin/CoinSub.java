package Ju.Coin;

public class CoinSub {
	String kr_name;
	String name;
	String last;
	String persent;

	public CoinSub() {

	}
	public CoinSub(String kr_name, String name, String last, String persent) {

		this.kr_name = kr_name;
		this.name = name;
		this.last = last;
		this.persent = persent;
	}

	public String getKr_name() {
		return kr_name;
	}

	public void setKr_name(String kr_name) {
		this.kr_name = kr_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersent() {
		return persent;
	}

	public void setPersent(String persent) {
		this.persent = persent;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}



}
