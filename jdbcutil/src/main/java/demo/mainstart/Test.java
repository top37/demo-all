package demo.mainstart;

import demo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 测试JDBCUtils工具类
 */
public class Test {
    public static void main(String[] args) {
        show();
    }

    private static void show() {
        /**
         * 获取数据库连接对象Connection
         */
        Connection conn = JDBCUtils.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            /**
             * 获取执行sql语句的执行者对象
             */
            stat = conn.createStatement();
            /**
             * 执行sql语句
             */
            String sql = "SELECT * FROM sqdemo1";
            rs = stat.executeQuery(sql);
            /**
             * 处理结果集,遍历Set集合
             */
            if (rs.next()) {
//                System.out.println(rs.getInt("cid") + "\t" + rs.getString("cname"));
                System.out.println(rs.getString("name") + "\t" + rs.getString("age"));
            } else {
                System.out.println("没有查询到指定的数据!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * 使用JDBCUtilsConfig工具类中的方法close释放资源
             */
            JDBCUtils.close(rs, stat, conn);
        }
    }

}
