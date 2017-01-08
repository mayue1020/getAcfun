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
            // 加载驱动  
            Class.forName(DRIVER);  
            System.out.println("测试加载驱动");
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
    
    public Connection getConn(String SQL) throws SQLException {  
        conn = null;  
        System.out.println("开始连接数据库");  
        try{  
            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        }catch(SQLException e){  
            e.printStackTrace();  
            System.out.println("数据库连接失败！");  
        }  
        System.out.println("数据库连接成功");  
        
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
        	System.out.println("sql失败");
        }
    }
    /* 
     * 关闭数据库连接，注意关闭的顺序 
     */  
    public void close(ResultSet rs, PreparedStatement ps, Connection conn) {  
        if(rs!=null){  
            try{  
                rs.close();  
                rs=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("关闭ResultSet失败");  
            }  
        }  
        if(ps!=null){  
            try{  
                ps.close();  
                ps=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("关闭PreparedStatement失败");  
            }  
        }  
        if(conn!=null){  
            try{  
                conn.close();  
                conn=null;  
            }catch(SQLException e){  
                e.printStackTrace();  
                System.out.println("关闭Connection失败");  
            }  
        }  
    }  
}  
    
    
    
