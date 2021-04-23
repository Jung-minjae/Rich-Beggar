package Ju.KD;

public class JusicSubDTO_KP {
	String up;
	String name;
	String price;
	String upPrice;
	String per;
	String code2;

	JusicSubDTO_KP() {

	}

	public JusicSubDTO_KP(String up, String name, String price, String upPrice, String per, String code2) {

		this.up = up;
		this.name = name;
		this.price = price;
		this.upPrice = upPrice;
		this.per = per;
		this.code2 = code2;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUpPrice() {
		return upPrice;
	}

	public void setUpPrice(String upPrice) {
		this.upPrice = upPrice;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

}
