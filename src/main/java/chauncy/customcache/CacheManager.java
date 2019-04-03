package chauncy.customcache;

import java.nio.channels.NetworkChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import chauncy.customsession.TokenUtils;

/**
 * @classDesc: 功能描述(提供缓存的API)
 * @author: ChauncyWang
 * @createTime: 2019年4月3日 上午10:38:13
 * @version: 1.0
 */
public class CacheManager {
	private static final CacheManager cacheManager=new CacheManager();
	
	private CacheManager(){
		
	}
	
	public static CacheManager getCacheManager(){
		return cacheManager;
	}
	
	// 存放缓存数据
	private Map<String, Cache> chacheMap = new HashMap<String, Cache>();

	public String put(String key, Object value) {
		String sessionId = put(key, value, null);
		return sessionId;
	}

	public synchronized String put(String key, Object value, Long timeout) {
		Cache cache = new Cache();
		//生成SessionId
		String sessionId=TokenUtils.getToken();
		cache.setSessionId(sessionId);
		cache.setKey(key);
		cache.setValue(value);
		if (timeout != null) {
			//保存的是整个毫秒数
			cache.setTimout(System.currentTimeMillis()+timeout);
		}
		chacheMap.put(key, cache);
		return sessionId;
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(删除api)  
	 * @author: ChauncyWang
	 * @param: @param key   
	 * @createTime: 2019年4月3日 上午11:00:10   
	 * @returnType: void
	 */
	public synchronized void del(String key) {
		System.out.println("key:"+key+"被删除");
		chacheMap.remove(key);	
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(使用key查询缓存)  
	 * @author: ChauncyWang
	 * @param: @param key
	 * @param: @return   
	 * @createTime: 2019年4月3日 上午10:59:49   
	 * @returnType: Object
	 */
	public synchronized Object get(String key){
		Cache cache = chacheMap.get(key);
		if(cache != null){
			return cache;
		}
		return null;
	}
	
	/**
	 * 
	 * @methodDesc: 功能描述(定时检查删除有效期的值)  
	 * @author: ChauncyWang
	 * @param:    
	 * @createTime: 2019年4月3日 上午11:10:16   
	 * @returnType: void
	 */
	public synchronized void checkValidityData(){
		for (String key : chacheMap.keySet()) {
			Cache cache = chacheMap.get(key);
			if(cache == null){
				break;
			}
			//检查有效期,获取缓存的毫秒数。
			Long timout = cache.getTimout();
			//计算时间差，获取当前时间毫秒数
			Long currentTime = System.currentTimeMillis();
			//说明已经过时
			if((currentTime-timout)>0){
				del(key);
			}
		}
	}

	public static void main(String[] args) {
		final CacheManager cacheManager = new CacheManager();
		//如果设置时间，开启一个线程，检查有效期
		cacheManager.put("userName", "123",5000l);
		System.out.println("保存成功。。。");
		//开启一个线程定期检查刷新数据
		// 入参为线程池大小，
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		// schedule执行定时任务线程池,第一个参数需要创建Runnable接口对象，第二、三个参数表示多少个单位时间执行run方法。
		newScheduledThreadPool.schedule(new Runnable() {
			public void run() {
				cacheManager.checkValidityData();
			}
		}, 5000, TimeUnit.MILLISECONDS);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Cache cache = (Cache) cacheManager.get("userName");
		System.out.println("userName:"+cache.getValue());	
	}
}
