package com.mvc.util;

import java.util.Scanner;

/**
 * @description �����
 * @author Kevin
 * 
 */
public class Detection {
	/**
	 * @description ���������Ƿ���ϱ�׼
	 * @param input
	 *            ��ȡ����
	 * @param count
	 *            ��Χ��(0, count]
	 * @return ����0����������
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

		System.out.println("�������󣡣�");
		return 0;

	}
}
