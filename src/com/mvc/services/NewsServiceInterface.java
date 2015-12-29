package com.mvc.services;

import java.util.Map;

import com.mvc.bean.News;
/**
 * @description 新闻服务
 * @author Kevin
 *
 */
public interface NewsServiceInterface {
	public abstract void add(News news);
	public abstract void delete(String newsId);
	public abstract void update(String nwesId);
	
	public abstract News getNewsByID(String newsId);
	
	public abstract Map<String, News> getAllNews();
	public abstract void saveNewsDate();
}
