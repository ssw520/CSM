package com.mvc.util;

import java.util.UUID;

public class MyUUID {
	/**
	 * @description �������ID
	 * @return
	 */
	public static String myID(){
		String string = null;
		string = UUID.randomUUID().toString();
		string = string.replace("-", "");
		return string;
	}
}
