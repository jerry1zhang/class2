package entity;

public class computer {
	private int c_id;
	private String type;
	private String pic;
	private String c_desc;
	private String price;
	private int num;
	
	public computer() {
	}
	
	public computer(int c_id, String type, String pic, String c_desc, String price, int num) {
		this.c_id = c_id;
		this.type = type;
		this.pic = pic;
		this.c_desc = c_desc;
		this.price = price;
		this.num = num;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getc_desc() {
		return c_desc;
	}
	public void setc_desc(String c_desc) {
		this.c_desc = c_desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
