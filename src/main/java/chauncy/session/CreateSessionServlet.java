package chauncy.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**   
 * @classDesc: 功能描述(创建Session)  
 * @author: ChauncyWang
 * @createTime: 2019年4月2日 下午4:14:34   
 * @version: 1.0  
 */
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getSession()无参数形式默认为true，如果没有Session，就会创建一个session，如果参数为false，如果没有找到Session，就不会创建session。
		HttpSession session = req.getSession();
		session.setAttribute("userName", "ChauncyWang");
		System.out.println("保存session成功！sessionId:"+session.getId());
	}
}
