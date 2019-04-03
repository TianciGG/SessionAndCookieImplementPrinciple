package chauncy.customcache;

/**   
 * @classDesc: 功能描述(缓存实体类)  
 * @author: ChauncyWang
 * @createTime: 2019年4月3日 上午10:32:52   
 * @version: 1.0  
 */  
public class Cache {
	//SessionId
	private String sessionId;
	//键
	private String key;
	//值
	private Object value;
	//有效期
	private Long timout;
	
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Long getTimout() {
		return timout;
	}
	public void setTimout(Long timout) {
		this.timout = timout;
	}
	
}
