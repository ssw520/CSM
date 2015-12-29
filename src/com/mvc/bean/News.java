package com.mvc.bean;
/**
 * @description ����
 * @author Kevin
 *
 */
public class News {
	private String userID; // �Ǹ��û����
	private String newsID; //���ű��
	private String title; //����
	private String newsType;// �������
	private String datasString;// ����
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
		String info = "\n���ű��⣺"+this.getTitle()+
				"\n����ID��"+this.getNewsID()+
				"\n�������ߣ�"+this.getUserID()+
				"\n�������"+this.getNewsType()+
				"\n�������ݣ�"+this.getDatasString();
		return info;
	}
	
}
