# SessionAndCookieImplementPrinciple Session与Cookie的底层实现原理
1.Cookie相关：chauncy.cookie.CreateCookieServlet.java创建Cookie、chauncy.cookie.GetCookieServlet.java获取Cookie、chauncy.cookie.LastAccessTime.java使用Cookie技术记录用户最后一次登录时间。
2.Session相关：chauncy.session.CreateSessionServlet.java创建Session、chauncy.session.GetSessionServlet.java获取Session
3.自定义缓存：chauncy.customcache.Cache.java缓存实体类、chauncy.customsession.TokenUtils.java使用jdk的UUID实现Token工具类、chauncy.customcache.CacheManager.java自定义缓存管理类
4.自定义Session:chauncy.customsession.SessionUtil.java实现Servelt的HttpSession功能。
5.Session+Token解决表单重复提交问题：chauncy.servlet.LocalFormServlet.java+form.jsp+chauncy.servlet.DoFormServlet.java
6.使用Filter防止XSS漏洞攻击：formToXss.jsp+chauncy.xss.XssDemo.java+showUserName.jsp+chauncy.filter.FilterDemo.java+chauncy.xss.XssAndSqlHttpServletRequestWrapper.java