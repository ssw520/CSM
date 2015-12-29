package com.mvc.util;

import java.util.Scanner;

/**
 * @description 检测类
 * @author Kevin
 * 
 */
public class Detection {
	/**
	 * @description 检测输入的是否符合标准
	 * @param input
	 *            读取输入
	 * @param count
	 *            范围：(0, count]
	 * @return 返回0：输入有误
	 */
	public static int detectionInt(int count) {
		int select = 0;
		Scanner input = new Scanner(System.in);
		if (input.hasNextInt()) {
			select = input.nextInt();
			if (select > 0 && select <= count) {
				return select;
			}
		}

		System.out.println("输入有误！！");
		return 0;

	}
}
