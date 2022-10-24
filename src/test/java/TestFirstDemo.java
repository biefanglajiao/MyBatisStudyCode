import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFirstDemo {
    //如何用java代码加载mybatis工具，实现user查询

    /****
     * 查找一个
     */
    @Test
    public void firstTest() {
        //1.读取说明书（mybatis-config.xml）
        String resourse = "mybatis-config.xml";
        //文本转换流读取
        try {
            Reader reader = Resources.getResourceAsReader(resourse);//生成对应流文件
            //2.sqlSession => SqlSessionFactory=>SqlSessionFactoryBuilder
            SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//将对应流文件读取
            SqlSession sqlSession = SqlSessionFactory.openSession();
            //3.利用理解生成的sqlsession对象操作数据
            User user = sqlSession.selectOne("selectUser", "aaa");
            System.out.println(user);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /***
     * 查找全部
     */
    @Test
    public void SelectAll() {
        //1.读取说明书（mybatis-config.xml）
        String resourse = "mybatis-config.xml";
        //文本转换流读取
        try {
            Reader reader = Resources.getResourceAsReader(resourse);//生成对应流文件
            //2.sqlSession => SqlSessionFactory=>SqlSessionFactoryBuilder
            SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//将对应流文件读取
            SqlSession sqlSession = SqlSessionFactory.openSession();
            //3.利用理解生成的sqlsession对象操作数据
            List<User> selectall = sqlSession.selectList("selectall");
            for (User user : selectall) {
                System.out.println(user);
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 插入数据
     */
    @Test
    public void insert() {
        String resourse = "mybatis-config.xml";
        SqlSession sqlSession = null;//这样可以在catch里面使用sqlsession
        try {
            Reader reader = Resources.getResourceAsReader(resourse);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            User user = new User();
            user.setName("changzhaohai");
            int insert = sqlSession.insert("insert", user);//sqlSession.insert("insert", "user");(插入值为user)
            System.out.println("成功插入：" + insert + "条数据");
            sqlSession.commit();

        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    /***
     * 更新方法
     */
    @Test
    public  void  update(){
        String resourse = "mybatis-config.xml";
        SqlSession sqlSession = null;//这样可以在catch里面使用sqlsession
        try {
            Reader reader = Resources.getResourceAsReader(resourse);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
//            Map<String,Object> map=new HashMap<>();
//            map.put("name","changzhaohai");
//            map.put("id",4);
            User user = new User();
            user.setName("changzhaohai");
            user.setId(2);
            int update = sqlSession.update("update", user);
            System.out.println("成功更新：" + update + "条数据");
            sqlSession.commit();

        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /***
     * delect
     */
@Test
    public  void delete(){
    String resourse = "mybatis-config.xml";
    SqlSession sqlSession = null;//这样可以在catch里面使用sqlsession
    try {
        Reader reader = Resources.getResourceAsReader(resourse);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setName("aaa");
        user.setId(4);

        int delete = sqlSession.delete("delete", user);
        System.out.println("成功删除：" + delete + "条数据");
        sqlSession.commit();

    } catch (IOException e) {
        sqlSession.rollback();
        e.printStackTrace();
    } finally {
        sqlSession.close();
    }
    }
}


