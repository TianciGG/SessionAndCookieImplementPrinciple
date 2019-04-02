package chauncy.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**   
 * @classDesc: 功能描述(获取Session)  
 * @author: ChauncyWang
 * @createTime: 2019年4月2日 下午4:24:31   
 * @version: 1.0  
 */  
@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session使用getSession(false)参数要为false
		HttpSession session = req.getSession(false);
		if(session != null){
			String userName = (String) session.getAttribute("userName");
			System.out.println("GetSessionServlet()----userName:"+userName);
			System.out.println("GetSessionServlet()----sessionId:"+session.getId());
		}else{
			System.out.println("没有找到任何结果");
		}
	}

}
