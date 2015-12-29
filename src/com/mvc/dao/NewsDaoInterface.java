package com.mvc.dao;

import java.util.Map;

import com.mvc.bean.News;
/**
 * @description 新闻服务
 * @author Kevin
 *
 */
public interface NewsDaoInterface {
	/**
	 * @description 添加一条新闻
	 * @param news
	 */
	public abstract void add(News news);
	/**
	 * @description 根据新闻ID删除此条新闻
	 * @param newsId
	 */
	public abstract void delete(String newsId);
	/**
	 * @description 更新新闻
	 * @param nwesId
	 */
	public abstract void update(String nwesId);
	/**
	 * @description 根据新闻ID显示新闻
	 * @param newsId
	 * @return
	 */
	public abstract News getNewsByID(String newsId);
	/**
	 * @description 返回所有新闻
	 * @return
	 */
	public abstract Map<String, News> getAllNews();
	public abstract void saveNewsDate();
}
