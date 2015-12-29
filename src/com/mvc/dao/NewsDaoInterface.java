package com.mvc.dao;

import java.util.Map;

import com.mvc.bean.News;
/**
 * @description ���ŷ���
 * @author Kevin
 *
 */
public interface NewsDaoInterface {
	/**
	 * @description ���һ������
	 * @param news
	 */
	public abstract void add(News news);
	/**
	 * @description ��������IDɾ����������
	 * @param newsId
	 */
	public abstract void delete(String newsId);
	/**
	 * @description ��������
	 * @param nwesId
	 */
	public abstract void update(String nwesId);
	/**
	 * @description ��������ID��ʾ����
	 * @param newsId
	 * @return
	 */
	public abstract News getNewsByID(String newsId);
	/**
	 * @description ������������
	 * @return
	 */
	public abstract Map<String, News> getAllNews();
	public abstract void saveNewsDate();
}
