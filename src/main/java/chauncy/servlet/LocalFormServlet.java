package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chauncy.customsession.TokenUtils;

/**   
 * @classDesc: 功能描述(跳转到form.jsp)  
 * @author: ChauncyWang
 * @createTime: 2019年4月7日 下午11:02:31   
 * @version: 1.0  
 */  
@WebServlet("/LocalFormServlet")
public class LocalFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//生成token
		String token=TokenUtils.getToken();
		HttpSession session = req.getSession();
		session.setAttribute("token", token);
		req.getRequestDispatcher("form.jsp").forward(req, resp);
	}
}
