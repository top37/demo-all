package demo;

import demo.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisTest {
    private static final String NAME_SPACE = "demo.dao.UserMapper";
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void beforeClass(){
        InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream("mybatis-configuration.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

//    static{
//
//    }
    /**
     * 查询单个记录
     * test 一级缓存
     */
    @Test
    public void testSelectOne() throws InterruptedException {
        SqlSession session = sqlSessionFactory.openSession();
        for(int i = 1;i <= 3;i++){
            User user = session.selectOne(NAME_SPACE+".selectByPrimaryKey", 2);
            System.out.println("第"+i+"次查询："+user);
            Thread.sleep(10000);
            System.out.println(session.getConfiguration().getCacheNames());
            session.flushStatements();
            session.clearCache();
        }
        session.close();
    }

    /**
     * 查询多个记录
     */
    @Test
    public void testSelectList(){
        SqlSession session = sqlSessionFactory.openSession();
        List<User> listUser = session.selectList(NAME_SPACE+".selectUserAll");
        if(listUser != null){
            System.out.println(listUser.size());
        }
        session.close();
    }

    /**
     * 插入一条记录
     */
    @Test
    public void testInsert(){
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User(2,"zhangsan",22);
        session.insert(NAME_SPACE+".insert", user);
        session.commit();
        session.close();
    }

    /**
     * 更新一条记录
     */
    @Test
    public void testUpdate(){

        SqlSession session = sqlSessionFactory.openSession();
        User user = new User(2,"lisi",22);
        session.update(NAME_SPACE+".updateByPrimaryKey", user);
        session.commit();
        session.close();
    }

    /**
     * 删除一条记录
     */
    @Test
    public void testDelete(){
        SqlSession session = sqlSessionFactory.openSession();
        session.delete(NAME_SPACE+".deleteByPrimaryKey", 2);
        session.commit();
        session.close();
    }

    /**
     * 删除一条记录（动态表名）
     */
    @Test
    public void testDelete1(){

        SqlSession session = sqlSessionFactory.openSession();

        int j = 0;
        for(Integer i = 1;i < 4;i++)
        {
            Map<String,Object> m = new HashMap<>();
            m.put("table_name","user"+i);
            m.put("userId",3);
            j = j + session.delete(NAME_SPACE+".deleteByPrimaryKey1", m);
            System.out.println("========>"+j);
        }
        session.commit();
        session.close();
    }

    @Test
    public void testSoutNull(){
        System.out.println("heheh"+null);
    }

    @Test
    public void testHotLoad() throws InterruptedException {
        for(int i = 0; i < 20 ;i++){
            Thread.sleep(5000);
            System.out.println(i+" : I am Z");
        }
    }



}
