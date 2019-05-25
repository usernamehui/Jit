package com.java.bc;

import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class BCcipher {
	
	public static SecretKey privateKey;//私钥key
	public static String type = "AES";//加密算法
	public static String typeMode = "AES/ECB/PKCS7Padding";//加密算法/加密模式/填充内容
	
	/**
	 * 初始化私钥Key
	 */
	static {
		//加解密引用第三方BC库
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
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
		/**
		 * 引入BC库 实现JDK 加解密
		 */
		//加密
		System.out.println(new String(encode("ABC")));
		//解密
		System.out.println(new String(decode(encode("ABC"))));
	}
	
	/**
	 * 加密
	 * @param content
	 * @return
	 */
	public static byte[] encode(String content) {
		try {
			Cipher cipher = Cipher.getInstance(typeMode);
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] encData = cipher.doFinal(content.getBytes("UTF-8"));
			return encData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 解密
	 * @param content
	 * @return
	 */
	public static byte[] decode(byte[] content) {
		try {
			Cipher cipher = Cipher.getInstance(typeMode);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] deData = cipher.doFinal(content);
			return deData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
