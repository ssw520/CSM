package com.mvc.bean;
/**
 * @description 新闻
 * @author Kevin
 *
 */
public class News {
	private String userID; // 那个用户存的
	private String newsID; //新闻编号
	private String title; //标题
	private String newsType;// 新闻类别
	private String datasString;// 内容
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return the newsID
	 */
	public String getNewsID() {
		return newsID;
	}
	/**
	 * @param newsID the newsID to set
	 */
	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the newsType
	 */
	public String getNewsType() {
		return newsType;
	}
	/**
	 * @param newsType the newsType to set
	 */
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	/**
	 * @return the datasString
	 */
	public String getDatasString() {
		return datasString;
	}
	/**
	 * @param datasString the datasString to set
	 */
	public void setDatasString(String datasString) {
		this.datasString = datasString;
	}
	/* (non-Javadoc)
	 * @description java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = "\n新闻标题："+this.getTitle()+
				"\n新闻ID："+this.getNewsID()+
				"\n新闻作者："+this.getUserID()+
				"\n新闻类别："+this.getNewsType()+
				"\n新闻内容："+this.getDatasString();
		return info;
	}
	
}
