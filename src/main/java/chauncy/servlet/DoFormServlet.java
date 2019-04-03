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
		req.setCharacterEncoding("UTF-8");
		String userName=req.getParameter("userName");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
		
		}
		System.out.println("数据库插入数据----userName:"+userName);
		//插入数据库。。。
		resp.getWriter().write("保存成功。。。");
	}
}
