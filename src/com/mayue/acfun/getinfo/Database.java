package com.mayue.acfun.getinfo;

import java.sql.*;

public class Database {
	private static String USERNAME = "sa";
	private static String PASSWORD = "Mrma88888888";
	private static String databese;
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://192.168.2.222:1433;databaseName=acfun";


	
    static {  
        try {  
            // ��������  
            Class.forName(DRIVER);  
            System.out.println("���Լ�������");
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
	private static Connection conn = null;
	
    public Connection getConn() throws SQLException {  
        conn = null;  
//        System.out.println("��ʼ�������ݿ�");  
        try{  
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        }catch(SQLException e){  
            e.printStackTrace();  
            System.out.println("���ݿ�����ʧ�ܣ�");  
        }  
//        System.out.println("���ݿ����ӳɹ�");  

        return conn;  
    }
    


    public String putSQL(String SQL) throws SQLException {
    	PreparedStatement pstmt = null;
        try{
        	int i = 0;
        	getConn();
//            for(i = 0;i!=0;){
        	
        		pstmt = conn.prepareStatement(SQL);
                pstmt.executeUpdate();
                pstmt.close();
//            }

//            do{
//            	PreparedStatement pstmt;
//                pstmt = conn.prepareStatement(SQL);
//                i = pstmt.executeUpdate();
//                pstmt.close();
//            }
//            while(i == 0);
//          int i = 0;
//          i = pstmt.executeUpdate();
//          if (i == 1){
//          System.out.println("resutl: " + i);

//          getConn().close();
            return "�ɹ�";
          }
//        }
        catch(Exception e){
        	System.out.println("sqlʧ��"+SQL);
        }
        return "ʧ��";
    }
    /* 
     * �ر����ݿ����ӣ�ע��رյ�˳�� 
     */  
    public void close(ResultSet rs, PreparedStatement ps, Connection conn) {  
        if(rs!=null){  
            try{  
                rs.close();  
                rs=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("�ر�ResultSetʧ��");  
            }  
        }  
        if(ps!=null){  
            try{  
                ps.close();  
                ps=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("�ر�PreparedStatementʧ��");  
            }  
        }  
        if(conn!=null){  
            try{  
                conn.close();  
                conn=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("�ر�Connectionʧ��");  
            }  
        }  
    }  
}  
    
    
    
