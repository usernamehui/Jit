package com.java.bc;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Ciphers {

	public static void main(String[] args) {
		
		//jdk AES 加密
		System.out.println(new String(jdkCipher("AES", "ABC".getBytes(), true)));
		
		//jdk AES 解密
		System.out.println(new String(jdkCipher("AES", jdkCipher("AES", "ABC".getBytes(), true), false)));
		
		
		
		
		
		
//		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//		try {
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
//			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("00000000000000000".getBytes("UTF-8"), "AES"));
//			byte[] encData = cipher.doFinal("QWEASDZS".getBytes("UTF-8"));
//			System.out.println(Base64.encodeBytes(encData));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
		
		
		
		
		
	}
	
	
	/**
	 * jdk 自带加密机
	 * @param type 		加解密 类型
	 * @param str  		加解密byte
	 * @param isDecode	是否加密(true加密  false解密)
	 * @return
	 */
	public static byte[] jdkCipher(String type,byte[] str,boolean isDecode) {
		/**
		 * java自带加密方式 
		 */
		try {
			if(isDecode) {//加密
				//构建 AES 加密算法对象
				Cipher cipher = Cipher.getInstance(type);
				//初始化为加密类型 -- 16位字符串的填充长度<加解密需一致>
				cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec("0000000000000000".getBytes("UTF-8"), type));
				//加密
				byte[] enDoFinal = cipher.doFinal(str);
//				System.out.println("AES 加密："+new String(enDoFinal));
				return enDoFinal;
			}
			
			if(!isDecode) {//解密
				//构建 AES 加密算法对象
				Cipher cipher = Cipher.getInstance(type);
				//初始化为解密类型 -- 16位字符串的填充长度<加解密需一致>
				cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec("0000000000000000".getBytes("UTF-8"), type));
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
