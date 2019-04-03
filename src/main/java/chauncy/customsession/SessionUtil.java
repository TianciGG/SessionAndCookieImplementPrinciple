package chauncy.customsession;

import chauncy.customcache.Cache;
import chauncy.customcache.CacheManager;

public class SessionUtil {
	
	private CacheManager cacheManager;
	
	/**
	 * 
	 * @methodDesc: 功能描述(初始化cacheManager)  
	 * @author: ChauncyWang
	 * @param:    
	 * @createTime: 2019年4月3日 下午3:03:35   
	 * @returnType: void
	 */
	public SessionUtil() {
		cacheManager=CacheManager.getCacheManager();
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(新增一个Session，返回一个SessionId)  
	 * @author: ChauncyWang
	 * @param: @param key
	 * @param: @param value
	 * @param: @return   
	 * @createTime: 2019年4月3日 下午3:11:34   
	 * @returnType: String
	 */
	public String setAttribute(String key,Object value){
		//生成SessionId
		String sessionId=cacheManager.put(key, value);
		return sessionId;
	}
	//通过key值获取缓存对象Cache，缓存对象包含sessionId和value值
	public Object getAttribute(String key){
		return cacheManager.get(key);
	}
	
	public static void main(String[] args) {
		SessionUtil sessionUtil = new SessionUtil();
		String setAttribute = sessionUtil.setAttribute("userName", "ChauncyWang");
		System.out.println("CreateSessionId:"+setAttribute);
		Cache cache = (Cache) sessionUtil.getAttribute("userName");
		System.out.printf("CacheEntity--->sessionId:"+cache.getSessionId()+"\tkey:"+cache.getKey()+"\tvalue:"+cache.getValue());
	}
}
