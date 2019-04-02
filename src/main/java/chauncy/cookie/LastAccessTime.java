package chauncy.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**   
 * @classDesc: 功能描述(显示用户最后一次访问的时间)  
 * @author: ChauncyWang
 * @createTime: 2019年4月2日 下午2:09:19   
 * @version: 1.0  
 */ 
@WebServlet("/LastAccessTime")
public class LastAccessTime extends HttpServlet{
	private static final String COOKIE_KEY_LASTACCESSTIME="COOKIE_KEY_LASTACCESSTIME";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");//防止浏览器产生乱码
		//1.获取Cookie信息
		Cookie[] cookies = req.getCookies();
		String lastAccessTime=null;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				String name = cookie.getName();
				if(COOKIE_KEY_LASTACCESSTIME.equals(name)){
					lastAccessTime=cookie.getValue();
					break;
				}
			}
		}
		//2.如果Cookie信息没有数据，说明第一次访问，有数据获取上一次Cookie的值。
		if(StringUtils.isEmpty(lastAccessTime)){
			resp.getWriter().write("您是首次访问！");
		}else{
			resp.getWriter().write("您上次访问时间为："+lastAccessTime);
		}
		//3.现在访问的登录时间存放在Cookie中
		//当前访问时间
		String currentTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
		//创建cookie将当前时间作为cookie保存到浏览器
		Cookie cookie = new Cookie(COOKIE_KEY_LASTACCESSTIME,currentTime);
		cookie.setMaxAge(60*60*24);
		//将cookie发送给客户端
		resp.addCookie(cookie);
	}
}
