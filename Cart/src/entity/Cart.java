package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private CartItem cartitem = new CartItem();
	private List<CartItem> cartlist = new ArrayList<CartItem>();
	
	public int add(Object huowu,int num){
		int flag = -1;
		for (int i = 0; i < cartlist.size(); i++) {
			if ((((computer)huowu).getC_id())==((computer)cartlist.get(i).getHuowu()).getC_id()) {
				System.out.println("info:cart find by huowu:"+((computer)cartlist.get(i).getHuowu()).getType());
//				cartlist.get(i).setNum(String.valueOf(cartlist.get(i).getNum()+1));
				flag = 0;
			}
		}
		if(flag==-1){
			cartitem = new CartItem();
			cartitem.setHuowu(huowu);
			cartitem.setNum(String.valueOf(num));
			cartitem = cartItemJiJia(cartitem);
			cartlist.add(cartitem);
		}
		return flag;
	}
	
	public void del(Object huowu){
		for (int i = 0; i < cartlist.size(); i++) {
			if (huowu.equals(cartlist.get(i).getHuowu())) {
				cartitem = cartlist.get(i);
			}
		}
		cartlist.remove(cartitem);
	}
	
	public List<CartItem> list(){
		return cartlist;
	}
	
	public void upda(Object huowu,int num){
		for (int i = 0; i < cartlist.size(); i++) {
			if (huowu.equals(cartlist.get(i).getHuowu())) {
				cartlist.get(i).setNum(String.valueOf(num));
				cartitem = cartItemJiJia(cartitem);
			}
		}
	}
	
	public void upda(int id,int num){
		Object huowu = findById(id);
		for (int i = 0; i < cartlist.size(); i++) {
			if (huowu.equals(cartlist.get(i).getHuowu())) {
				cartlist.get(i).setNum(String.valueOf(num));
				cartitem = cartItemJiJia(cartitem);
			}
		}
	}
	
	public int jijia(){
		System.out.println("info:Cart.jijia()");
		int zongjia = 0;
		for(CartItem c:cartlist){
			zongjia += (Integer.valueOf(((computer)c.getHuowu()).getPrice())*Integer.valueOf(c.getNum()));
		}
		return zongjia;
	}
	
	public Object findById(int id){
		Object huowu = null;
		for (CartItem c:cartlist) {
			if (id==((computer)c.getHuowu()).getC_id()) {
				huowu = c.getHuowu();
			}
		}
		return huowu;
	}
	
	public CartItem cartItemJiJia(CartItem c){
		c.setZongjia(String.valueOf(Integer.valueOf(((computer)c.getHuowu()).getPrice())*Integer.valueOf(c.getNum())));
		return c;
	}
}
