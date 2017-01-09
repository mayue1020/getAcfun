package com.mayue.acfun.getinfo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAcfun {

	static String acID;
	static String upTime;
	static String banana;
	static String title;
	static String content;		
	static String username;
	static String userid;
	static String viewCount;
	static String collect;
	static String comment;
	static String channelID;
	static Document document;
	
	
	public String put(int ac) throws Exception{
//		acID = ac;
		getAction(ac);
		String sql ="'"+acID+"','"+upTime+"','"+banana+"','"+title+"','"+content+"','"+username+"','"+userid+"','"+viewCount+"','"+collect+"','"+comment+"','"+channelID+"'";
		
		return sql;
	}

	public static boolean getAction(int ac) throws Exception{
//		acID=3372389;
		try{
			document = Jsoup.connect("http://www.acfun.cn/v/ac"+ac)
					  .data("query", "Java")
					  .userAgent("Android FireFox/29")
					  .cookie("auth", "token")
					  .timeout(3000)
					  .post();

	//��ȡҳ�����
			Element pageInfo = document.getElementById("pageInfo");
			try{
				pageInfo.attr("data-title");
				//��ȡ�ϴ�ʱ��
				Elements getTime = document.getElementsByClass("time");
				upTime = getTime.get(1).html();
		//��ȡ�㽶����
				Elements getBanana = document.getElementsByAttributeValue("class", "sp4");//�����㽶�������Ԫ��
				banana =getBanana.get(3).html();	//getBanana������Ϊ�㽶����,get(3)Ϊ������ĸ�
		//ͨ��Ԫ������ȷ���󲿷�����
				acID = pageInfo.attr("data-aid");
				title = pageInfo.attr("data-title");			
				content = pageInfo.attr("data-desc");		
				username = pageInfo.attr("data-name");
				userid = pageInfo.attr("data-uid");
				viewCount = pageInfo.attr("data-view");
				collect = pageInfo.attr("data-collect");
				comment = pageInfo.attr("data-comment");
				channelID = pageInfo.attr("data-cid");
				//�ַ�����Ӣ�ĵ����Żᵼ��sql����
				title = title.replace("'", "''");		
				content = content.replace("'", "''");		
				username = username.replace("'", "''");
				userid = userid.replace("'", "��");
				viewCount = viewCount.replace("'", "''");
				collect = collect.replace("'", "''");
				comment = comment.replace("'", "''");
				channelID = channelID.replace("'", "''");
				return true;
			}
			catch(Exception e){
				acID = ac+"";
				title = "1";			
				content = "1";		
				username = "1";
				userid = "1";
				viewCount = "1";
				collect = "1";
				comment = "1";
				channelID = "1";
				banana = "1";
				upTime = "2017-01-05 15:15:00.000";
				return true;
			}


		}
		catch(Exception e){
			acID = ac+"";
			title = "1";			
			content = "1";		
			username = "1";
			userid = "1";
			viewCount = "1";
			collect = "1";
			comment = "1";
			channelID = "1";
			banana = "1";
			upTime = "2017-01-05 15:15:00.000";
			return true;
		}
		}

}
