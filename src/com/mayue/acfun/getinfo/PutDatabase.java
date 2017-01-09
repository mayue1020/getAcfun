package com.mayue.acfun.getinfo;

import java.sql.SQLException;



public class PutDatabase {
	
	static String str1 = "insert into [acfun].[dbo].[video_info]([acID],[upTime],[banana],[title],[content],[username],[userid],[viewCount],[collect],[comment],[channelID]) values (";
	static String str2 = ")";

	static int t; 

	
	static GetAcfun a = new GetAcfun();//建立对象获取数据
	static Database conn = new Database();
	
	public static void PutDatebase(int ac,int t) throws Exception {

		int i = 0;
		String sql = null;
		conn.getConn();
		for( ac=ac;ac<=t;ac++){		
			try {
				sql = str1+a.put(ac)+str2;
				conn.putSQL(sql);
				System.out.print(ac+"\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
	}
	
	
	public static void PutDate(int ac) throws Exception {

		String sql = null;
//		conn.getConn();
		try {
			sql = str1+a.put(ac)+str2;
			conn.putSQL(sql);
			System.out.print(ac+"\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}


