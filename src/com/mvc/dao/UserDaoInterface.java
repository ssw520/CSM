package com.mvc.dao;

import java.util.Map;

import com.mvc.bean.User;

/**
 * @description �û��������
 * @author Kevin
 * 
 */
public interface UserDaoInterface {
	public abstract void add(User user);

	public abstract void delete(String id);

	public abstract void update(User user);

	/**
	 * ����Id����û���Ϣ
	 * 
	 * @param id
	 * @return �����û�
	 */
	public abstract User getUserByID(String id);


	/**
	 * @return �������е��û�
	 */
	public abstract Map<String, User> getAllUser();

	/**
	 * ��������Ա
	 * 
	 * @param user
	 *            Ҫ���ĵ��û�
	 * @param Power
	 *            ����Ϊ��Ȩ��
	 */
	public abstract void changeUserPower(User user, int Power);
	/**
	 * @description �����ݵ����ݿ�
	 */
	public abstract void saveUserDate();
}
