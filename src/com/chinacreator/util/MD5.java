package com.chinacreator.util;

import java.security.MessageDigest;

/**
 * @Description 
	MD5加密工具类
 * @Author qiang.zhu
 * @Datetime 2016年8月4日 上午10:50:54
 * @Version 
 * @Copyright (c) 2013 湖南科创信息技术股份有限公司

 */
public class MD5 {
	
	/**
	 * @Description 
		MD5加密
	 * @Author qiang.zhu
	 * @param content 明文
	 * @return String 密文
	 */
	public static String getMD5Str(String content){
		byte[] resultByteArray = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(content.getBytes("GBK"));
			resultByteArray = messageDigest.digest(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArrayToHex(resultByteArray);
	}
	private static String byteArrayToHex(byte[] byteArray) {  
        // 首先初始化一个字符数组，用来存放每个16进制字符  
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））  
        char[] resultCharArray =new char[byteArray.length * 2];  
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去  
        int index = 0; 
        for (byte b : byteArray) {  
           resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];  
           resultCharArray[index++] = hexDigits[b& 0xf];  
        }
        // 字符数组组合成字符串返回  
        return new String(resultCharArray);  
    }
}
