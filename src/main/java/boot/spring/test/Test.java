package boot.spring.test;

import java.sql.*; /**
 * 2 * @Author: ly
 * 3 * @Date: 2019/4/28 下午9:49
 * 4
 */

/**
 *@Description TODO
 *@Author Simida
 **/
public class Test {
    public static void main(String[] args){
        //执行Sql
        try {
            Connection conn = getConnection();
            String sql = "select * from user";
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        Connection conn = null;//桥梁
        String url = "jdbc:mysql://47.99.108.50:3306/xsd446?"
                + "user=caokun&password=Ck163com!"+
                "&useUnicode=true&&characterEncoding=UTF-8&useSSL=false";
        try{
            Class.forName("com.mysql.jdbc.Driver");//通往MYSQL
            conn = DriverManager.getConnection(url);//桥梁构建已经成功了 --
        }catch (ClassNotFoundException e){
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        }catch (SQLException e) {
            System.out.println("SQL 执行错误");
        } catch (Exception e) {
            System.out.println("其他错误");
            e.printStackTrace();
        }
        return conn;
        //运行时   非受检
        //编译     受检
        /*Connection conn = null; // 创建一个connection

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://47.99.108.50:3306/xsd446?"
                    + "user=caokun&password=Ck163com!"+
                    "&useUnicode=true&&characterEncoding=UTF-8&useSSL=false";
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL 执行错误");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;*/
    }
}
