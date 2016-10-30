package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.biz;
import biz.bizimpl;
import entity.Cart;
import entity.computer;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private biz biz = new bizimpl();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = cut(req.getRequestURI());
//    	Cookie[] cookies = req.getCookies();
    	HttpSession session = req.getSession();
    	computer computer;
    	Cart cart;
//    	String cookie = cookieValue("JSESSIONID", cookies);
    	if ("/computerList".equals(path)) {
			List<computer> list = biz.allComputer();
			resp.setContentType("text/html;charset=utf-8");
			req.setAttribute("list", list);
			req.getRequestDispatcher("computer_list.jsp").forward(req, resp);
		}else if ("/joinCart".equals(path)) {
			req.setCharacterEncoding("utf-8");
			Integer cid = Integer.valueOf(req.getParameter("id"));
			computer = biz.findById(cid);
			cart = (Cart)session.getAttribute("cart");
			System.out.println(session);
			if (cart!=null) {
			}else{
				cart = new Cart();
			}
			int flag = cart.add(computer, 1);
			session.setAttribute("cart", cart);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			if (flag==-1) {
				out.append("商品加入购物车成功!!!3秒后回到商品列表");
			}else{
				out.append("商品已经加入过购物车了");
			}
			resp.setHeader("Refresh", "3;URL=computerList.do");
		}else if("/cartList".equals(path)){
			cart = (Cart)session.getAttribute("cart");
			if(cart!=null){
				int val = cart.jijia();
				req.setAttribute("list", cart.list());
				req.setAttribute("zongjia", val);
				req.getRequestDispatcher("cart_list.jsp").forward(req, resp);
			}else{
				PrintWriter out = resp.getWriter();
				out.append("购物车为空");
			}
		}
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = cut(req.getRequestURI());
    	Cookie[] cookies = req.getCookies();
    	String cookie = cookieValue("JSESSIONID", cookies);
    	HttpSession session = req.getSession();
    	Cart cart;
    	if ("/joinCart".equals(path)) {
		}else if("/change".equals(path)){
			int id = Integer.valueOf(req.getParameter("id"));
			int num = Integer.valueOf(req.getParameter("num"));
			System.out.println(num);
			cart = (Cart)session.getAttribute("cart");
			cart.upda(id,num);
			session.setAttribute("cart", cart);
			req.getRequestDispatcher("cart_list.jsp").forward(req, resp);
		}
    }
    
    private String cut(String uri){
    	return uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
    }
    
    private String cookieValue(String cookieKey,Cookie[] cookies){
    	String cookie = new String();
    	for(Cookie c:cookies){
    		if (cookieKey.equals(c.getName())) {
				cookie = c.getValue();
			}
    	}
    	return cookie;
    }

}
