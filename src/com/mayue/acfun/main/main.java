package com.mayue.acfun.main;

import com.mayue.acfun.getinfo.PutDatabase;


public class main {

	public static void main(String[] args) throws Exception {
		int num = 100000;
		int start = 10;
		int end = 0;
		String SQL = null;
		// TODO Auto-generated method stub
        MutliThread1 m1=new MutliThread1();
        m1.setAC(end+1);
        m1.setT(num);
        m1.start();
        
        MutliThread1 m2=new MutliThread1();
        m2.setAC(num+1);
        m2.setT(num*2);
        m2.start();

        MutliThread1 m3=new MutliThread1();
        m3.setAC(num*2+1);
        m3.setT(num*3);
        m3.start();
        
        MutliThread1 m4=new MutliThread1();
        m4.setAC(num*3+1);
        m4.setT(num*4);
        m4.start();
        
        MutliThread1 m5=new MutliThread1();
        m5.setAC(num*4+1);
        m5.setT(num*5);
        m5.start();
        
        MutliThread1 m6=new MutliThread1();
        m6.setAC(num*5+1);
        m6.setT(num*6);
        m6.start();
        
        MutliThread1 m7=new MutliThread1();
        m7.setAC(num*6+1);
        m7.setT(num*7);
        m7.start();
        
        MutliThread1 m8=new MutliThread1();
        m8.setAC(num*7+1);
        m8.setT(num*8);
        m8.start();
        
        MutliThread1 m9=new MutliThread1();
        m9.setAC(num*8+1);
        m9.setT(num*9);
        m9.start();
        
        MutliThread1 m10=new MutliThread1();
        m10.setAC(num*9+1);
        m10.setT(num*10);
        m10.start();
//		PutDatabase a2 = new PutDatabase();
//		a2.PutDatebase();
        

        
        
	}
	
	static class MutliThread1 extends Thread{
		static int ac;
		static int t;
		static String sql;
		public void setAC(int ac){
			this.ac=ac;
		}
		public void setT(int t){
			this.t=t;
		}
		
		public String getSQL(){
			return sql;
		}
		
		public void run(){
			PutDatabase a = new PutDatabase();
			a.setAC(ac);
			a.setT(t);
			try {
				a.PutDatebase();
				this.sql = a.getSQL();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}