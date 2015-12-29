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
	 * @description 新闻菜单
	 */
	public void mainMenuNews() {
		while (true) {
			String menuString = " ******************************************新闻模块*************************************\n"
					+ "1.退出\t 2.返回上一级\t 3.显示所有新闻\t ";
			int key;
			if (this.userThis.getAccount().getPower() == 2) {
				System.out.println(menuString);
				key = Detection.detectionInt(3);
			} else {
				menuString += "4.添加新闻\t 5.删除新闻\t";
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
	 * @description 保存新闻到本地文件
	 */
	public void saveNews() {
		newsService.saveNewsDate();
	}

	/**
	 * @description 显示所有的新闻
	 */
	public void shows() {
		Map<String, News> mapNews = newsService.getAllNews();
		if(mapNews == null){
			System.out.println("无新闻！");
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
	 * @description 添加新闻
	 * @param userID
	 */
	public void addNews(String userID) {
		News news = inputNews(userID);
		newsService.add(news);
	}

	public void deleteNews() {
		String newsID = null;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入删除的新闻ID号:");
		newsID = input.next();
		newsService.delete(newsID);
	}

	/**
	 * @description 新闻的输入
	 * @param userID
	 *            存新闻的管理员用户ID
	 * @return 一条新闻
	 */
	public News inputNews(String userID) {
		// String userID; // 那个用户存的
		String newsID; // 新闻编号
		String title; // 标题
		String newsType;// 新闻类别
		String datasString;// 内容
		Scanner input = new Scanner(System.in);

		System.out.println("请输入新闻标题:");
		title = input.next();
		System.out.println("请输入新闻类别:");
		newsType = input.next();
		System.out.println("请输入新闻内容：");
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
