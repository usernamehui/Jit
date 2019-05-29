package com.java.enums;


public enum EnumTest {
	//枚举实例
	RED,BLUE,GREEN;
	public static void main(String[] args) {
		//枚举实例对象
		System.out.println(RED);
		//枚举实例名称字符串
		System.out.println(RED.name());
		//枚举实例序号（按顺序从0开始）
		System.out.println(BLUE.ordinal());
		//判断两个枚举类型是否相同(相同 0 不相同 -1)
		System.out.println(RED.compareTo(BLUE));
	}
}



enum EnumTest2{
		//枚举实例
		RED("KEY","VAL");
		
		public static String key;
		public static String val;
		public void setKey(String key) {
			EnumTest2.key = key;
		}
		public void setVal(String val) {
			EnumTest2.val = val;
		}
		EnumTest2(String key,String val) {
			setKey(key);
			setVal(val);
		}
		public static void main(String[] args) {
			//枚举实例对象
			System.out.println(RED);
			//枚举实例名称字符串
			System.out.println(RED.name());
			//枚举实例序号（按顺序从0开始）
			System.out.println(RED.ordinal());
			//判断两个枚举类型是否相同(相同 0 不相同 -1)
			System.out.println(RED.compareTo(RED));
			//获取枚举中的常量字符串
			System.out.println(EnumTest2.key+"---"+EnumTest2.val);
		}
}
