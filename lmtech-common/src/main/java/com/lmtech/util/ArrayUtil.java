package com.lmtech.util;

import java.util.Arrays;

public class ArrayUtil {
	
	/**
	 * 合并数组
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> T[] concat(T[] first, T[] second) {  
		  T[] result = Arrays.copyOf(first, first.length + second.length);  
		  System.arraycopy(second, 0, result, first.length, second.length);  
		  return result;  
	}
	
	/**
	 * 合并数组
	 * @param first
	 * @param second
	 * @return
	 */
	public static byte [] concat(byte[] first, byte[] second) {
		byte[] result = Arrays.copyOf(first, first.length + second.length);  
		System.arraycopy(second, 0, result, first.length, second.length);  
		return result;  
	}
}
