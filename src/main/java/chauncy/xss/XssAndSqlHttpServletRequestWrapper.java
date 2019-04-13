package chauncy.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**   
 * @classDesc: 功能描述(防止XSS攻击)  
 * @author: ChauncyWang
 * @createTime: 2019年4月8日 下午4:32:43   
 * @version: 1.0  
 */  
public class XssAndSqlHttpServletRequestWrapper extends HttpServletRequestWrapper{
	HttpServletRequest request;
	
	public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	/**
	 * 将request中的value值重写一下，将一些脚本参数、非法参数转换成html元素执行。
	 */
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		System.out.println("name:"+name+",转换前value:"+value);
		if(!StringUtils.isEmpty(value)){
			//转换html
			value=StringEscapeUtils.escapeHtml4(value);
			System.out.println("转换后value:");
		}
		return value;
	}
}
