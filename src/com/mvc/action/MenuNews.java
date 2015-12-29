package com.mvc.action;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import com.mvc.bean.News;
import com.mvc.bean.User;
import com.mvc.services.NewsService;
import com.mvc.util.DataTemple;
import com.mvc.util.Detection;
import com.mvc.util.MyUUID;

public class MenuNews {
	NewsService newsService = new NewsService();
	User userThis = DataTemple.userCuntter;

	public MenuNews() {
	};

	public MenuNews(User user) {
		this.userThis = user;
	}

	public void setUserThis(User user) {
		this.userThis = user;
	}

	/**
	 * @description ���Ų˵�
	 */
	public void mainMenuNews() {
		while (true) {
			String menuString = " ******************************************����ģ��*************************************\n"
					+ "1.�˳�\t 2.������һ��\t 3.��ʾ��������\t ";
			int key;
			if (this.userThis.getAccount().getPower() == 2) {
				System.out.println(menuString);
				key = Detection.detectionInt(3);
			} else {
				menuString += "4.�������\t 5.ɾ������\t";
				System.out.println(menuString);
				key = Detection.detectionInt(5);
			}

			switch (key) {
			case 1:
				saveNews();
				System.exit(0);
			case 2:
				saveNews();
				return;
			case 3:
				shows();
				break;
			case 4:
				addNews(this.userThis.getAccount().getId());
				saveNews();
				break;
			case 5:
				deleteNews();
				saveNews();
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @description �������ŵ������ļ�
	 */
	public void saveNews() {
		newsService.saveNewsDate();
	}

	/**
	 * @description ��ʾ���е�����
	 */
	public void shows() {
		Map<String, News> mapNews = newsService.getAllNews();
		if(mapNews == null){
			System.out.println("�����ţ�");
			return ;
		}
		Set<Entry<String, News>> set = mapNews.entrySet();
		Iterator<Entry<String, News>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, News> entry = (Entry<String, News>) iterator
					.next();
			News news = entry.getValue();

			System.out.println(news);
		}
	}

	/**
	 * @description �������
	 * @param userID
	 */
	public void addNews(String userID) {
		News news = inputNews(userID);
		newsService.add(news);
	}

	public void deleteNews() {
		String newsID = null;
		Scanner input = new Scanner(System.in);
		System.out.println("������ɾ��������ID��:");
		newsID = input.next();
		newsService.delete(newsID);
	}

	/**
	 * @description ���ŵ�����
	 * @param userID
	 *            �����ŵĹ���Ա�û�ID
	 * @return һ������
	 */
	public News inputNews(String userID) {
		// String userID; // �Ǹ��û����
		String newsID; // ���ű��
		String title; // ����
		String newsType;// �������
		String datasString;// ����
		Scanner input = new Scanner(System.in);

		System.out.println("���������ű���:");
		title = input.next();
		System.out.println("�������������:");
		newsType = input.next();
		System.out.println("�������������ݣ�");
		datasString = input.next();
		newsID = MyUUID.myID().hashCode()+"";
		News news = new News();
		news.setDatasString(datasString);
		news.setNewsID(newsID);
		news.setNewsType(newsType);
		news.setTitle(title);
		news.setUserID(userID);

		return news;
	}
}
