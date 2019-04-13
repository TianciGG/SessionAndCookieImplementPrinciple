package chauncy.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chauncy.xss.XssAndSqlHttpServletRequestWrapper;

/**   
 * @classDesc: 功能描述(使用Filter打印参数)  
 * @author: ChauncyWang
 * @createTime: 2019年4月8日 下午2:58:43   
 * @version: 1.0  
 */  
public class FilterDemo implements Filter{
	
	public FilterDemo(){
		System.out.println("FilterDemo无参构造函数被执行。。。");
	}
	
	/**
	 * 初始化，只执行一次
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init...");
	}
	
	/**
	 * 如果doFilter方法不放行的话，那么就不会执行。
	 */
	public void doFilter(ServletRequest paramRequest, ServletResponse paramResponse, FilterChain paramFilterChain	)
			throws IOException, ServletException {
		System.out.println("doFilter...");
		HttpServletRequest request = (HttpServletRequest) paramRequest;
		XssAndSqlHttpServletRequestWrapper xssRequestWrapper = new XssAndSqlHttpServletRequestWrapper(request); 
		/*HttpServletResponse response= (HttpServletResponse) paramResponse;
		//请求地址
		String requestURI = request.getRequestURI();
		System.out.println("requestURI:"+requestURI);
		//参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			String[] strArr=parameterMap.get(key);
			System.out.println("key:");
			for(String string : strArr){
				System.out.println(string+"，");
			}
		}*/
		paramFilterChain.doFilter(xssRequestWrapper, paramResponse);
	}
	
	/**
	 * 销毁，只执行一次
	 */
	public void destroy() {
		System.out.println("destroy...");
	}

}
