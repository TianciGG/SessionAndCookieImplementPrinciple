package chauncy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 
 * Cookie默认浏览器关闭失效  
 * @classDesc: 功能描述(获取Cookie)  
 * @author: ChauncyWang
 * @createTime: 2019年4月2日 上午10:58:22   
 * @version: 1.0  
 */  
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取所有的Cookie信息
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName()+"---"+cookie.getValue());
			}
		}else{
			System.out.println("cookie为null");
		}
	}
}
