package com.mayue.acfun.getinfo;

import java.sql.*;

public class Database {
	private static String USERNAME = "sa";
	private static String PASSWORD = "Mrma88888888";
	private static String databese;
	private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://simpleme.cc:1433;databaseName=acfun";
	private static Connection conn = null;
    
    static {  
        try {  
            // ��������  
            Class.forName(DRIVER);  
            System.out.println("���Լ�������");
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public Connection getConn(String SQL) throws SQLException {  
        conn = null;  
        System.out.println("��ʼ�������ݿ�");  
        try{  
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        }catch(SQLException e){  
            e.printStackTrace();  
            System.out.println("���ݿ�����ʧ�ܣ�");  
        }  
        System.out.println("���ݿ����ӳɹ�");  
        
//        PreparedStatement pstmt;
//        pstmt = conn.prepareStatement(SQL);
//        int i = 0;
//        i = pstmt.executeUpdate();
//        System.out.println("resutl: " + i);
//        pstmt.close();

        return conn;  
    }
    
    public void putSQL(String SQL) throws SQLException {
    	getConn(SQL);
        PreparedStatement pstmt;
        try{
            pstmt = conn.prepareStatement(SQL);
            int i = 0;
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            getConn(SQL).close();
        }
        catch(Exception e){
        	System.out.println("sqlʧ��");
        }
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
    
    
    
