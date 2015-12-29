package com.mvc.util.iofile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mvc.bean.News;

public class NewsData {
	 String path = "NewsData.txt";

	/**
	 * @description 新闻输出
	 * @param outMap
	 */
	public void outData(Map<String, News> outMap) {
		String fileoutput = path; // 文件路径
		DataOutputStream dataOutputStream = null;
		try {
			File file = new File(fileoutput);
			if (!file.exists()) {
				file.createNewFile();
			}
			dataOutputStream = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(fileoutput)));

			Set<Entry<String, News>> set = outMap.entrySet();
			Iterator<Entry<String, News>> iterator = set.iterator();

			while (iterator.hasNext()) {
				Map.Entry<String, News> entry = (Entry<String, News>) iterator
						.next();
				News news = entry.getValue(); // 获取map中的数据

				String title = news.getTitle(); // 标题
				String newsID = news.getNewsID(); // 新闻编号
				String userID = news.getUserID(); // 那个用户存的
				String newsType = news.getNewsType();// 新闻类别
				String datasString = news.getDatasString();// 内容

				/*
				 * 读取本地数据
				 */
				dataOutputStream.writeUTF(title);
				dataOutputStream.writeUTF(newsID);
				dataOutputStream.writeUTF(userID);
				dataOutputStream.writeUTF(newsType);
				dataOutputStream.writeUTF(datasString);

			}
			dataOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @description 新闻输入
	 * @return Map
	 */
	public Map<String, News> inData() {
		Map<String, News> newsMap = new HashMap<String, News>();
		String fileinput = path;
		DataInputStream dataInputStream = null;
		try {
			File file = new File(fileinput);
			if (!file.exists()) {
				file.createNewFile();
			}
			dataInputStream = new DataInputStream(new BufferedInputStream(
					new FileInputStream(fileinput)));
			try {
				while (true) {
					News news = new News();// 缓存
		
					String title = dataInputStream.readUTF(); // 标题
					String newsID = dataInputStream.readUTF(); // 新闻编号
					String userID = dataInputStream.readUTF(); // 那个用户存的
					String newsType = dataInputStream.readUTF();// 新闻类别
					String datasString = dataInputStream.readUTF();// 内容

					news.setUserID(userID);
					news.setNewsID(newsID);
					news.setTitle(title);
					news.setNewsType(newsType);
					news.setDatasString(datasString);

					newsMap.put(news.getNewsID(), news);// 装入map
				}
			} catch (EOFException e) {
			}
			dataInputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return newsMap;
	}

}
