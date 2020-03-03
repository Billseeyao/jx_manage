package main.java.com.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
* @author barry.wang

 * @date 2016年10月27日 下午9:59:27
 */
public class ReMessage extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public ReMessage() {
		put("code", 0);
	}

	public static ReMessage error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static ReMessage error(String msg) {
		return error(500, msg);
	}

	public static ReMessage error(int code, String msg) {
		ReMessage r = new ReMessage();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static ReMessage ok(String msg) {
		ReMessage r = new ReMessage();
		r.put("msg", msg);
		return r;
	}

	public static ReMessage ok(Map<String, Object> map) {
		ReMessage r = new ReMessage();
		r.putAll(map);
		return r;
	}

	public static ReMessage ok() {
		return new ReMessage();
	}

	public ReMessage put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
