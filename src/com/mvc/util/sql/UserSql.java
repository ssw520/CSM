package com.mvc.util.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.mvc.bean.Account;
import com.mvc.bean.User;

public class UserSql {
	/**
	 * @see 读取数据的用户信息
	 * @return 所有的用户信息
	 */
	public Map<String, User> getAllUser() {
		Map<String, User> userMap = new HashMap<String, User>();
		String sql = "select id, password, power, name, age, sex from user_tb";
		DBHelper dbHelper = null;
		ResultSet resultSet = null;
		try {
			dbHelper = new DBHelper(sql);
			resultSet = dbHelper.pst.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				Account account = new Account();
				String id = resultSet.getString(1);
				String password = resultSet.getString(2);
				int power = resultSet.getInt(3);

				String name = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String sex = resultSet.getString(6);

				account.setId(id);
				account.setPassword(password);
				account.setPower(power);

				user.setAccount(account);
				user.setUserName(name);
				user.setUserSex(sex);
				user.setUserAge(age);
				userMap.put(user.getAccount().getId(), user);

			}
			resultSet.close();
			dbHelper.close();
		} catch (SQLException e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
		return userMap;
	}

	/**
	 * @see 根据ID返回一个用户
	 * @param id
	 * @return
	 */
	public User getUserByID(String id) {
		String sql = "select id, password, power, name, age, sex from user_tb where id = ?";
		User user = null;
		DBHelper dbHelper = null;
		ResultSet resultSet = null;
		try {
			dbHelper = new DBHelper(sql);
			int index = 1;
			dbHelper.pst.setObject(index++, id);
			resultSet = dbHelper.pst.executeQuery();
			while (resultSet.next()) {
				user = new User();
				Account account = new Account();

				id = resultSet.getString(1);
				String password = resultSet.getString(2);
				int power = resultSet.getInt(3);
				String name = resultSet.getString(4);
				int age = resultSet.getInt(5);
				String sex = resultSet.getString(6);

				account.setId(id);
				account.setPassword(password);
				account.setPower(power);

				user.setAccount(account);
				user.setUserName(name);
				user.setUserSex(sex);
				user.setUserAge(age);
			}
			resultSet.close();
			dbHelper.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}
		return user;
	}

	/**
	 * @see 删除一个用户
	 * @param id
	 *            用户ID
	 */
	public boolean delet(String id) {
		String sql = "delete from user_tb where id=?";
		DBHelper dbHelper = null;
		try {
			dbHelper = new DBHelper(sql);

			int index = 1;
			dbHelper.pst.setObject(index++, id);
			int f = dbHelper.pst.executeUpdate();
			if (f > 0) {
				System.out.println("删除成功");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * @see 增加一个用户
	 * @param userMap
	 */
	public boolean save(User user) {

		String id = user.getAccount().getId();
		String password = user.getAccount().getPassword();
		int power = user.getAccount().getPower();
		String name = user.getUserName();
		String sex = user.getUserSex();
		int age = 20;
		String sql = "insert into user_tb (id, password, power, name, age, sex)values(?,?,?,?,?,?);";

		DBHelper dbHelper = null;

		try {
			dbHelper = new DBHelper(sql);
			int index = 1;
			dbHelper.pst.setObject(index++, id);
			dbHelper.pst.setObject(index++, password);
			dbHelper.pst.setObject(index++, power);
			dbHelper.pst.setObject(index++, name);
			dbHelper.pst.setObject(index++, age);
			dbHelper.pst.setObject(index++, sex);

			int f = dbHelper.pst.executeUpdate();

			if (f > 0) {
				System.out.println("添加成功！");
				return true;
			}
			dbHelper.close();
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return false;
	}

	/**
	 * @see 更新一个用户
	 * @param user
	 */
	public boolean update(User user) {
		DBHelper dbHelper = null;
		String id = user.getAccount().getId();
		String password = user.getAccount().getPassword();
		int power = user.getAccount().getPower();
		String name = user.getUserName();
		String sex = user.getUserSex();
		int age = user.getUserAge();
		String sql = "update user_tb set password=?, power=?, name=?, sex=?, age=?  where id=?";
		try {
			dbHelper = new DBHelper(sql);
			int index = 1;
			dbHelper.pst.setObject(index++, password);
			dbHelper.pst.setObject(index++, power);
			dbHelper.pst.setObject(index++, name);
			dbHelper.pst.setObject(index++, sex);
			dbHelper.pst.setObject(index++, age);
			dbHelper.pst.setObject(index++, id);

			int f = dbHelper.pst.executeUpdate();
			if (f > 0) {
				System.out.println("更新成功");
				return true;
			}
			dbHelper.close();
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return false;
	}
}
