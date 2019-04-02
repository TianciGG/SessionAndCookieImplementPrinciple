package chauncy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**   
 * @classDesc: 功能描述(创建Cookie)  
 * @author: ChauncyWang
 * @createTime: 2019年4月2日 上午10:16:06   
 * @version: 1.0  
 */  
@WebServlet("/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//key value 自定义Cookie
		Cookie cookie = new Cookie("userName", "123456");
		//如果是负数，浏览器关闭失效，如果是正数，以秒为单位进行保存。
		cookie.setMaxAge(60*60*24);//cookie保存一天，没有任何一家公司能永久保存登录，说永久只不过把值设置的比较大。
		//将Cookie发送给客户端
		resp.addCookie(cookie);
		System.out.println("创建Cookie成功！");
	}
}
