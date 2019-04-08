package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoFormServlet")
public class DoFormServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");//防止浏览器产生乱码
		if(!isSubmit(req)){
			System.out.println("已经提交了数据，或者该sessionId错误，不允许重复提交。");
			resp.getWriter().write("已经提交了数据，或者该sessionId错误，不允许重复提交。");
			return;
		}
		String userName=req.getParameter("userName");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
		
		}
		System.out.println("数据库插入数据----userName:"+userName);
		//插入数据库。。。
		resp.getWriter().write("保存成功。。。");
		req.getSession().removeAttribute("token");
	}
	
	
	public Boolean isSubmit(HttpServletRequest request){
		String parameterToken = request.getParameter("token");
		String sessionToken = (String) request.getSession().getAttribute("token");
		//判断该session是否可提交
		if(sessionToken == null){
			return false;
		}
		//判断该session是否为伪造token
		if(!(parameterToken.equals(sessionToken))){
			return false;
		}
		return true;
	}
}
