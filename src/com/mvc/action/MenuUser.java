package com.mvc.action;

import java.util.Map;
import java.util.Scanner;
import com.mvc.bean.Account;
import com.mvc.bean.User;
import com.mvc.services.UserService;
import com.mvc.util.DataTemple;
import com.mvc.util.Detection;

/**
 * @description User菜单
 * @author Kevin
 * 
 */
public class MenuUser {
	UserService userService = new UserService();// 服务

	/**
	 * @description 主菜单
	 */
	public void mainMenu() {
		System.out.println("\n****************************欢迎使用系统*************************************");
		menu();
	}

	/**
	 * @description 登录，注册菜单
	 */
	public void menu() {
		while (true) {
			System.out.println("1.登陆\t 2.注册\t 3.退出");
			int key = Detection.detectionInt(3);
			switch (key) {
			case 1:
				login(); // 登陆
				menu();
				break;
			case 2:
				register(); // 注册
				menu();
				break;
			case 3:
				System.exit(0); // 退出
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @description 登录
	 */
	public void login() {
		Scanner input = new Scanner(System.in);
		String accountID; // 账号ID
		String password; // 账号密码

		System.out.println("请输入账号ID：");
		accountID = input.next();

		System.out.println("请输入密码：");
		password = input.next();

		User user = userService.getUserByID(accountID);
		if (user != null) {
			if (user.getAccount().getPassword().equals(password)) {
				DataTemple.userCuntter = user;
				System.out.println("登陆成功");
				menuLogin();
			} else {
				System.out.println("密码不正确！");
			}
		} else {
			System.out.println("账号不正确！");
		}
	}

	/**
	 * @description 管理员菜单
	 */
	public void menuLogin() {
		while (true) {
			Scanner input = new Scanner(System.in);
			int key;
			String menuString = "1.退出\t  2.返回上一级\t  3.修改用户信息\t 4.管理新闻模块\t";
			if (DataTemple.userCuntter.getAccount().getId().equals("admin")) {
				menuString += "5.查看所有人信息\t 6.更改其它用户权限\t 7.删除用户\t ";
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
				String id; // 更改账号的ID
				int power;
				User user;
				System.out.println("请输入账号ID：");
				id = input.next();
				user = userService.getUserByID(id); // 获取用户信息
				if (user != null) {
					System.out.println(user);
					System.out.println("请输入级别(1-2)：");
					while (0 == (power = Detection.detectionInt(2)))
						System.out.println("请输入级别(1-2)：");
					userService.changeUserPower(user, power);
				} else {
					System.out.println("用户不存在");
				}
				break;

			case 7:
				String id2; // 删除账号的ID
				System.out.println("请输入账号ID：");
				id2 = input.next();
				if (id2.equals("admin") == false) {
					user = userService.getUserByID(id2); // 获取用户信息
					if (user != null) {
						System.out.println(user);
						userService.delete(id2);
					} else {
						System.out.println("用户不存在");
					}
				} else {
					System.out.println("此用户无法删除！");
				}
				break;

			default:
				break;
			}
		}
	}

	/**
	 * @description 注册
	 */
	public void register() {
		User user = infoInput();
		userService.add(user);
		// savaUserInfo();
	}

	/**
	 * @description 用户信息输入
	 * 
	 * @return User
	 */
	public User infoInput() {
		Scanner input = new Scanner(System.in);
		User user; // 用户
		Account account; // 账户
		String accountID; // 账号ID
		String password; // 账号密码
		String name; // 用户姓名
		int age; // 用户年龄
		String sex; // 用户性别

		System.out.println("请输入账号ID");
		accountID = input.next();
		System.out.println("请输入账号密码");
		password = input.next();
		System.out.println("请输入用户姓名");
		name = input.next();
		System.out.println("请输入用户年龄");
		while ((age = Detection.detectionInt(100)) == 0)
			System.out.println("请输入用户年龄");
		System.out.println("请输入用户性别");
		sex = input.next();

		account = new Account();
		account.setId(accountID);
		account.setPassword(password);
		account.setPower(2);// 默认2级

		user = new User();
		user.setAccount(account);
		user.setUserName(name);
		user.setUserSex(sex);
		user.setUserAge(age);

		return user;
	}

	/**
	 * @description 修改用户信息
	 */
	public void changeUserInfo() {
		Scanner input = new Scanner(System.in);
		User user; // 用户
		//Account account; // 账户
		String accountID = DataTemple.userCuntter.getAccount().getId(); // 账号ID
		String password; // 账号密码
		String name; // 用户姓名
		int age; // 用户年龄
		String sex; // 用户性别
		if (accountID.equals("admin")) { // 超级管理员
			System.out.println("请输入账号ID");
			accountID = input.next();
		}
		user = userService.getUserByID(accountID);
		if (user != null) {
			System.out.println("请输入账号密码");
			password = input.next();
			System.out.println("请输入用户姓名");
			name = input.next();
			System.out.println("请输入用户年龄");
			while ((age = Detection.detectionInt(100)) == 0)
				System.out.println("请输入用户年龄");
			System.out.println("请输入用户性别");
			sex = input.next();

			user.getAccount().setPassword(password);
			// user.getAccount().setPower(power);
			user.setUserName(name);
			user.setUserSex(sex);
			user.setUserAge(age);

			userService.update(user);
		} else {
			System.out.println("无次用户");
		}
	}

	/**
	 * @description 显示所有用户信息
	 */
	public void showAllUser() {
		Map<String, User> userMap = userService.getAllUser();
		// 方法一
		if(userMap == null){
			System.out.println("无用户");
			return ;
		}
		for (String obj : userMap.keySet()) {
			User value = userMap.get(obj);
			System.out.println(value);
		}

		// 方法二
		/*
		 * for (Map.Entry<String, User> entry : userMap.entrySet()) {
		 * System.out.println(entry.getValue()); }
		 */// 方法三
		/*
		 * Set set = userMap.entrySet(); Iterator i = set.iterator(); while
		 * (i.hasNext()) { Map.Entry<String, User> entry1 = (Map.Entry<String,
		 * User>) i.next(); System.out.println(entry1.getValue());}
		 */
		// 方法四
		/*
		 * Iterator it = userMap.keySet().iterator(); while (it.hasNext()) {
		 * String key; User userValue; key = it.next().toString(); userValue =
		 * userMap.get(key); System.out.println(userValue); }
		 */// 方法五
		/*
		 * Iterator iterator = userMap.entrySet().iterator(); String key; String
		 * valueUser; while (it.hasNext()) { Map.Entry entry = (Map.Entry)
		 * it.next(); key = entry.getKey().toString(); valueUser =
		 * entry.getValue().toString(); System.out.println(valueUser); }
		 */

	}

}
