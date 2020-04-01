package cn.proflu.profluweb.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

/**
 * 项目名称：
 * 
 * @author:fh
 * 
 */
public class Const {
	/**
	 * 陆向谦推荐相关常量
	 */
	public static final String APP_ID = "wxe4fac813a0d128d3";
	public static final String APP_SECRET = "fe9f5049b65ac70d7f91f84d79c22585";
	public static final String OS_KEY = "RVCQS9UR56";
	public static final Map SUCCESS_RESPONSE = new HashMap();
	public static final Map FAIL_RESPONSE = new HashMap();
	public static final Map SESSION_INVALID_RESPONSE = new HashMap();

	static {
		SUCCESS_RESPONSE.put("code", 1);
		SUCCESS_RESPONSE.put("msg", "success");
		FAIL_RESPONSE.put("code", 0);
		FAIL_RESPONSE.put("msg", "fail");
		SESSION_INVALID_RESPONSE.put("code", -1);
		SESSION_INVALID_RESPONSE.put("msg", "invalid session");
	}
	public static Map getResultMap(){
		return new HashMap();
	}
}
