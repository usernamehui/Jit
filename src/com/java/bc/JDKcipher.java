package com.java.bc;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class JDKcipher {
	
	public static SecretKey privateKey;//私钥key
	public static String type = "AES";//加密算法
	
	/**
	 * 初始化私钥Key
	 */
	static {
		KeyGenerator instance;
		try {
			/**
			    *    对称加密
			 * AES 加密 = 16位
			 * DES 加密= 56位
			 */
			int count = 0;
			switch(type) {
				case "AES" : count = 128;break;
				case "DES" : count = 56;break;
			}
			instance = KeyGenerator.getInstance(type);
			instance.init(count,new SecureRandom("".getBytes()));
			privateKey = instance.generateKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		
		//jdk AES 加密
		System.out.println(new String(jdkCipher("abcdefg".getBytes(), true)));
		
		//jdk AES 解密
		System.out.println(new String(jdkCipher(jdkCipher("abcdefg".getBytes(), true), false)));
		
	}
	
	
	/**
	 * jdk 自带加密机
	 * @param type 		加解密 算法
	 * @param str  		加解密byte
	 * @param isDecode	是否加密(true加密  false解密)
	 * @return
	 */
	public static byte[] jdkCipher(byte[] str,boolean isDecode) {
		try {
			if(isDecode) {//加密
				//构建 AES 加密算法对象
				Cipher cipher = Cipher.getInstance(type);
				//初始化操作模式 加密类型 -- AES密钥为 16位字符串<加解密需一致>
				cipher.init(Cipher.ENCRYPT_MODE, privateKey);
				//加密
				byte[] enDoFinal = cipher.doFinal(str);
//				System.out.println("AES 加密："+new String(enDoFinal));
				return enDoFinal;
			}
			
			if(!isDecode) {//解密
				//构建 AES 加密算法对象
				Cipher cipher = Cipher.getInstance(type);
				//初始化操作模式 解密类型 -- AES密钥为 16位字符串<加解密需一致>
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				//解密
				byte[] deDoFinal = cipher.doFinal(str);
//				System.out.println("AES 解密："+new String(deDoFinal));
				return deDoFinal;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


}
