package com.mvc.services;

import java.util.Map;

import com.mvc.bean.News;
import com.mvc.dao.NewsDao;

public class NewsService implements NewsServiceInterface {
	private NewsDao newsDao = new NewsDao();

	@Override
	public void add(News news) {
		// TODO Auto-generated method stub
		newsDao.add(news);
	}

	@Override
	public void delete(String newsId) {
		// TODO Auto-generated method stub
		newsDao.delete(newsId);
	}

	@Override
	public void update(String nwesId) {
		// TODO Auto-generated method stub
		newsDao.update(nwesId);
	}

	@Override
	public News getNewsByID(String newsId) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByID(newsId);
	}

	@Override
	public Map<String, News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDao.getAllNews();
	}

	@Override
	public void saveNewsDate() {
		newsDao.saveNewsDate();
	}
}
