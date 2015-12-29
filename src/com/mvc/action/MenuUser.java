package com.mvc.action;

import java.util.Map;
import java.util.Scanner;
import com.mvc.bean.Account;
import com.mvc.bean.User;
import com.mvc.services.UserService;
import com.mvc.util.DataTemple;
import com.mvc.util.Detection;

/**
 * @description User�˵�
 * @author Kevin
 * 
 */
public class MenuUser {
	UserService userService = new UserService();// ����

	/**
	 * @description ���˵�
	 */
	public void mainMenu() {
		System.out.println("\n****************************��ӭʹ��ϵͳ*************************************");
		menu();
	}

	/**
	 * @description ��¼��ע��˵�
	 */
	public void menu() {
		while (true) {
			System.out.println("1.��½\t 2.ע��\t 3.�˳�");
			int key = Detection.detectionInt(3);
			switch (key) {
			case 1:
				login(); // ��½
				menu();
				break;
			case 2:
				register(); // ע��
				menu();
				break;
			case 3:
				System.exit(0); // �˳�
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @description ��¼
	 */
	public void login() {
		Scanner input = new Scanner(System.in);
		String accountID; // �˺�ID
		String password; // �˺�����

		System.out.println("�������˺�ID��");
		accountID = input.next();

		System.out.println("���������룺");
		password = input.next();

		User user = userService.getUserByID(accountID);
		if (user != null) {
			if (user.getAccount().getPassword().equals(password)) {
				DataTemple.userCuntter = user;
				System.out.println("��½�ɹ�");
				menuLogin();
			} else {
				System.out.println("���벻��ȷ��");
			}
		} else {
			System.out.println("�˺Ų���ȷ��");
		}
	}

	/**
	 * @description ����Ա�˵�
	 */
	public void menuLogin() {
		while (true) {
			Scanner input = new Scanner(System.in);
			int key;
			String menuString = "1.�˳�\t  2.������һ��\t  3.�޸��û���Ϣ\t 4.��������ģ��\t";
			if (DataTemple.userCuntter.getAccount().getId().equals("admin")) {
				menuString += "5.�鿴��������Ϣ\t 6.���������û�Ȩ��\t 7.ɾ���û�\t ";
				System.out.println(menuString);
				key = Detection.detectionInt(7);
			} else {
				System.out.println(menuString);
				key = Detection.detectionInt(4);
			}
			switch (key) {
			case 1:
				System.exit(0);
			case 2:
				return;
			case 3:
				changeUserInfo();
				break;
			case 4:
				MenuNews menuNews = new MenuNews();
				menuNews.mainMenuNews();
				break;
			case 5:
				showAllUser();
				break;
			case 6:
				String id; // �����˺ŵ�ID
				int power;
				User user;
				System.out.println("�������˺�ID��");
				id = input.next();
				user = userService.getUserByID(id); // ��ȡ�û���Ϣ
				if (user != null) {
					System.out.println(user);
					System.out.println("�����뼶��(1-2)��");
					while (0 == (power = Detection.detectionInt(2)))
						System.out.println("�����뼶��(1-2)��");
					userService.changeUserPower(user, power);
				} else {
					System.out.println("�û�������");
				}
				break;

			case 7:
				String id2; // ɾ���˺ŵ�ID
				System.out.println("�������˺�ID��");
				id2 = input.next();
				if (id2.equals("admin") == false) {
					user = userService.getUserByID(id2); // ��ȡ�û���Ϣ
					if (user != null) {
						System.out.println(user);
						userService.delete(id2);
					} else {
						System.out.println("�û�������");
					}
				} else {
					System.out.println("���û��޷�ɾ����");
				}
				break;

			default:
				break;
			}
		}
	}

	/**
	 * @description ע��
	 */
	public void register() {
		User user = infoInput();
		userService.add(user);
		// savaUserInfo();
	}

	/**
	 * @description �û���Ϣ����
	 * 
	 * @return User
	 */
	public User infoInput() {
		Scanner input = new Scanner(System.in);
		User user; // �û�
		Account account; // �˻�
		String accountID; // �˺�ID
		String password; // �˺�����
		String name; // �û�����
		int age; // �û�����
		String sex; // �û��Ա�

		System.out.println("�������˺�ID");
		accountID = input.next();
		System.out.println("�������˺�����");
		password = input.next();
		System.out.println("�������û�����");
		name = input.next();
		System.out.println("�������û�����");
		while ((age = Detection.detectionInt(100)) == 0)
			System.out.println("�������û�����");
		System.out.println("�������û��Ա�");
		sex = input.next();

		account = new Account();
		account.setId(accountID);
		account.setPassword(password);
		account.setPower(2);// Ĭ��2��

		user = new User();
		user.setAccount(account);
		user.setUserName(name);
		user.setUserSex(sex);
		user.setUserAge(age);

		return user;
	}

	/**
	 * @description �޸��û���Ϣ
	 */
	public void changeUserInfo() {
		Scanner input = new Scanner(System.in);
		User user; // �û�
		//Account account; // �˻�
		String accountID = DataTemple.userCuntter.getAccount().getId(); // �˺�ID
		String password; // �˺�����
		String name; // �û�����
		int age; // �û�����
		String sex; // �û��Ա�
		if (accountID.equals("admin")) { // ��������Ա
			System.out.println("�������˺�ID");
			accountID = input.next();
		}
		user = userService.getUserByID(accountID);
		if (user != null) {
			System.out.println("�������˺�����");
			password = input.next();
			System.out.println("�������û�����");
			name = input.next();
			System.out.println("�������û�����");
			while ((age = Detection.detectionInt(100)) == 0)
				System.out.println("�������û�����");
			System.out.println("�������û��Ա�");
			sex = input.next();

			user.getAccount().setPassword(password);
			// user.getAccount().setPower(power);
			user.setUserName(name);
			user.setUserSex(sex);
			user.setUserAge(age);

			userService.update(user);
		} else {
			System.out.println("�޴��û�");
		}
	}

	/**
	 * @description ��ʾ�����û���Ϣ
	 */
	public void showAllUser() {
		Map<String, User> userMap = userService.getAllUser();
		// ����һ
		if(userMap == null){
			System.out.println("���û�");
			return ;
		}
		for (String obj : userMap.keySet()) {
			User value = userMap.get(obj);
			System.out.println(value);
		}

		// ������
		/*
		 * for (Map.Entry<String, User> entry : userMap.entrySet()) {
		 * System.out.println(entry.getValue()); }
		 */// ������
		/*
		 * Set set = userMap.entrySet(); Iterator i = set.iterator(); while
		 * (i.hasNext()) { Map.Entry<String, User> entry1 = (Map.Entry<String,
		 * User>) i.next(); System.out.println(entry1.getValue());}
		 */
		// ������
		/*
		 * Iterator it = userMap.keySet().iterator(); while (it.hasNext()) {
		 * String key; User userValue; key = it.next().toString(); userValue =
		 * userMap.get(key); System.out.println(userValue); }
		 */// ������
		/*
		 * Iterator iterator = userMap.entrySet().iterator(); String key; String
		 * valueUser; while (it.hasNext()) { Map.Entry entry = (Map.Entry)
		 * it.next(); key = entry.getKey().toString(); valueUser =
		 * entry.getValue().toString(); System.out.println(valueUser); }
		 */

	}

}
