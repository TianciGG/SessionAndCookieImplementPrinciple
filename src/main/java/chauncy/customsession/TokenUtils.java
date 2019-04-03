package chauncy.customsession;

import java.util.UUID;

/**
 * Token其实就是一个令牌，随机生成，有有效期，不能重重复。
 * Token类似于SessionId；   
 * @classDesc: 功能描述(使用UUID实现Token工具类)  
 * @author: ChauncyWang
 * @createTime: 2019年4月3日 下午3:24:40   
 * @version: 1.0  
 */  
public class TokenUtils {
	static public String getToken(){
		return UUID.randomUUID().toString();
	}
	public static void main(String[] args) {
		System.out.println(TokenUtils.getToken());
	}
}
