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
	 * @description �������
	 * @param outMap
	 */
	public void outData(Map<String, News> outMap) {
		String fileoutput = path; // �ļ�·��
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
				News news = entry.getValue(); // ��ȡmap�е�����

				String title = news.getTitle(); // ����
				String newsID = news.getNewsID(); // ���ű��
				String userID = news.getUserID(); // �Ǹ��û����
				String newsType = news.getNewsType();// �������
				String datasString = news.getDatasString();// ����

				/*
				 * ��ȡ��������
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
	 * @description ��������
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
					News news = new News();// ����
		
					String title = dataInputStream.readUTF(); // ����
					String newsID = dataInputStream.readUTF(); // ���ű��
					String userID = dataInputStream.readUTF(); // �Ǹ��û����
					String newsType = dataInputStream.readUTF();// �������
					String datasString = dataInputStream.readUTF();// ����

					news.setUserID(userID);
					news.setNewsID(newsID);
					news.setTitle(title);
					news.setNewsType(newsType);
					news.setDatasString(datasString);

					newsMap.put(news.getNewsID(), news);// װ��map
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
