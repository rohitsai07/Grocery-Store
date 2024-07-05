package HelperClasses;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UtilityResources {
	
	public static Map<String,String> get_cookies_map(HttpServletRequest request){
		Cookie cookies[] = request.getCookies();	
		Map<String,String> cookies_map = new HashMap<String,String>();
		for(int i=0;i<cookies.length;i++) {
			cookies_map.put(cookies[i].getName(), cookies[i].getValue());
		}
		return cookies_map;
	}

}
