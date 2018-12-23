package com._520it.shop.util;

public class StringUtil {
	private StringUtil() {}
	
	public static boolean hasLength(String str) {
		return str != null && str.trim().length() > 0;
	}
}
