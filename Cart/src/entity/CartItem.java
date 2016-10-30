package entity;

public class CartItem {
	private Object huowu;
	private String num;
	private String zongjia;
	
	public String getZongjia() {
		return zongjia;
	}

	public void setZongjia(String zongjia) {
		this.zongjia = zongjia;
	}

	public CartItem() {
	}
	
	public CartItem(Object huowu,String num) {
		this.huowu = huowu;
		this.num = num;
	}
	
	public Object getHuowu() {
		return huowu;
	}
	public void setHuowu(Object huowu) {
		this.huowu = huowu;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
