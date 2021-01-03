package com.cxh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 连接数据库的工具类
 */
public class DBUtils {
    // 驱动器路径
    private static  String DRIVER ;
    //连接数据库地址
    private static  String URL;
    //数据库用户名
    private static  String USER_NAME;
    //数据库密码
    private static  String USER_PASSWORD;
    //静态代码块
    static{
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //取出类型
        String type = properties.getProperty("type");
        DRIVER=properties.getProperty(type+"_driver");
        URL=properties.getProperty(type+"_url");
        USER_NAME=properties.getProperty(type+"_username");
        USER_PASSWORD=properties.getProperty(type+"_password");
    }

    /**
     * 获取数据库的连接对象
     * @return
     */
    public static Connection getConnection(){
        //1,加载驱动
        try {
            Class.forName(DRIVER);
            //        建立数据的连接
            Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载数据库驱动失败");
        }
        return null;
    }

    /**
     * 通过连接去得到PreparedStatement
     * @param conn 连接对象
     * @param sql  SQL语句
     * @param args  占位符的参数
     */
    public static PreparedStatement prepareStatement(Connection conn,String sql,Object[] args){
        PreparedStatement pstmt=null;
        try{
            pstmt=conn.prepareStatement(sql);
            if(args!=null){
                for (int i = 0; i <args.length ; i++) {
                    pstmt.setObject((i+1),args[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pstmt;
    }
    /**
     * 封装 执行添加，修改，删除方法
     */
    private static int executeUpdate(PreparedStatement pstmt){
        int i=0;
        try
        {
            i = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("执行成功，受影响的行数为:"+i);
        return i;
    }

    /**
     *  封装 执行添加，修改，删除方法
     */
    public static int executeUpdate(String sql,Object[] args){
        //得到连接
        Connection conn = getConnection();
        //得到执行对象
        PreparedStatement pstmt = prepareStatement(conn, sql, args);
        int i=executeUpdate(pstmt);
        close(pstmt);
        close(conn);
        return i;
    }

    /**
     * 封装，查询的结果集的方法
     */
    public static ResultSet executeQuery(PreparedStatement pstmt){
        ResultSet rs=null;
        try
        {
            rs=pstmt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    /**
     *  封装，查询的结果集的方法
     */
    public static ResultSet executeQuery(String sql,Object...args){
        Connection conn = getConnection();
        PreparedStatement pstmt = prepareStatement(conn, sql, args);
        ResultSet rs = executeQuery(pstmt);
        return rs;
    }

    /**
     * 关闭的方法
     */
    public static void close(AutoCloseable closeable){
        if(null!=closeable){
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
