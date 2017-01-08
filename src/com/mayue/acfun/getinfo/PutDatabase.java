package com.mayue.acfun.getinfo;

import java.sql.SQLException;

//import com.mayue.acfun.main.main.MutliThread2;
//import com.mayue.acfun.main.main.MutliThread3;
//import com.mayue.acfun.main.main.MutliThread4;

public class PutDatabase {
	
	static String str1 = "insert into [acfun].[dbo].[video_info]([acID],[upTime],[banana],[title],[content],[username],[userid],[viewCount],[collect],[comment],[channelID]) values (";
	static String str2 = ")";
	static String sql = null;
	static int t = 10; 
	static Database test = new Database();

	static int ac = 0;
	static int ab = 0;
	public String getSQL(){
		
		return sql;
	}
	public int setT(int t){
		this.t = t;
		return t;
	}
	public int getT(){
		return t;
	}
	
	public int getAC(){
		return ac;
	}
	public int setAC(int ac){
		this.ac=ac;
		return ac;
	}
	
	public int getAB(){
		return ab;
	}	
	public int setAB(int ab){
		this.ab=ab;
		return ab;
	}
	
	public static int PutDatebase() throws Exception {
		System.out.println("getConn\n");
		
//        MutliThread m1=new MutliThread();
//        m1.start();
		GetAcfun a = new GetAcfun();//建立对象获取数据
		try {
			sql = str1+a.put(0)+str2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		for( ac = ab;ac<=t;ac++){
//			if (ac%100==1&&ac>=100){
//				sql=null;
//				}
			try {
				sql = sql + "\n" + str1+a.put(ac)+str2;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ac%1==0){
				System.out.print(ac+"\n");
				if (ac%t==0&&ac>=5){
					updata();
					}
				}
			}
        return 0;
	}
	
    static class MutliThread extends Thread {

	    public void run(){
			GetAcfun a = new GetAcfun();//建立对象获取数据
			try {
				sql = str1+a.put(0)+str2;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			for( ac = ab;ac<=t;ac++){
//				if (ac%100==1&&ac>=100){
//					sql=null;
//					}
				try {
					sql = sql + "\n" + str1+a.put(ac)+str2;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(ac%1==0){
					System.out.print(ac+"\n");
					if (ac%t==0&&ac>=5){
						updata();
						}
					}
				}

			}

	    }

	    public static void updata(){
	    	Database test = new Database();
			try {
//				test.getConn(sql);
				test.putSQL(sql);
				System.out.println("ac"+ac+"已上传\n");
				System.out.println(sql+"\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("updata执行完成"+"\n");
	
	    }
	    
	    public static void updataError(){
	    	Database test = new Database();
			try {
//				test.getConn(sql);
				test.putSQL(sql);
				System.out.println("ac"+ac+"出现错误输出\n");
				System.out.println(sql+"\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("updata执行完成"+"\n");
	
	    }
}