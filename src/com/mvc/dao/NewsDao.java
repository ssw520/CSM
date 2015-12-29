package com.mvc.dao;

import java.util.HashMap;
import java.util.Map;
import com.mvc.bean.News;
import com.mvc.util.iofile.NewsData;

public class NewsDao implements NewsDaoInterface {

	private static Map<String, News> newsMap = new HashMap<String, News>();	
	static {
		NewsData newsData = new NewsData();
		newsMap = newsData.inData();
	}

	@Override
	public void add(News news) {
		if (null != newsMap.put(news.getNewsID(), news)) {
			System.out.println("���ʧ�ܣ�");
		} else {
			System.out.println("��ӳɹ���");
		}
		/*int size = newsMap.size();
		newsMap.put(news.getNewsID(), news);
		if(size != newsMap.size() ){
			System.out.println("��ӳɹ���");
		}else {
			System.out.println("���ʧ�ܣ�");
		}*/
	}

	@Override
	public void delete(String newsId) {
		/*int size = newsMap.size();
		newsMap.remove(newsId);
		if(size != newsMap.size() ){
			System.out.println("ɾ���ɹ���");
		}else {
			System.out.println("ɾ��ʧ�ܣ�");
		}*/
		if (newsMap.remove(newsId)== null) {
			System.out.println("ɾ��ʧ�ܣ�");
		} else {
			System.out.println("ɾ���ɹ�");
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String nwesId) {
		// TODO Auto-generated method stub

	}

	@Override
	public News getNewsByID(String newsId) {
		// TODO Auto-generated method stub
		News news = newsMap.get(newsId);
		if (news != null) {
			return news;
		}
		System.out.println("δ�ҵ�IDΪ:" + newsId + "������");
		return null;
	}

	@Override
	public Map<String, News> getAllNews() {
		// TODO Auto-generated method stub
		if (newsMap.isEmpty()) {
			return null;
		}
		return newsMap;
	}
	@Override
	public void saveNewsDate(){
		NewsData newsData = new NewsData();
		newsData.outData(newsMap);
	}
}
