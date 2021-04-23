package Ju.KP;

public class JusicSubDTO {
	String up;
	String name;
	String price;
	String upPrice;
	String per;
	String code;
	

	public String getUp() {
		return up;
	}
	public void setUp(String up) {
		this.up = up;
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public JusicSubDTO(String up, String name, String price, String upPrice, String per, String code) {

		this.up = up;
		this.name = name;
		this.price = price;
		this.upPrice = upPrice;
		this.per = per;
		this.code = code;
	}

}

