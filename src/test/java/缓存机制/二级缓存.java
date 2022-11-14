package 缓存机制;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.User;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class 二级缓存 {
    /****
     * 对user表查询应证二级缓存
     */
    @Test
    public void text(){//嵌套查询

        String reserous="mybatis-config.xml";
        try {
            Reader reader= Resources.getResourceAsReader(reserous);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession1=sqlSessionFactory.openSession();
            System.out.println("*****************************第一次查询--------------------------");
            //第一次查询
            Object selectUserid = sqlSession1.selectOne("selectUserid", 1);
            System.out.println(selectUserid);
            sqlSession1.close();

            System.out.println("*****************************第二次查询--------------------------");
            //第二次查询
            SqlSession sqlSession2=sqlSessionFactory.openSession();
            Object selectUserid1 = sqlSession2.selectOne("selectUserid", 1);
            System.out.println(selectUserid1);
            sqlSession2.close();
            //其他修改
            System.out.println("*****************************其他修改(与原数据无关)--------------------------");
            SqlSession sqlSession3=sqlSessionFactory.openSession();
            int insert = sqlSession3.insert("insert", "这是其他修改");
            System.out.println("其他修改共修改了"+insert+"条数据");
            sqlSession3.commit();
            sqlSession3.close();

            System.out.println("*****************************第三次查询--------------------------");
            //第三次查询
            SqlSession sqlSession4=sqlSessionFactory.openSession();
            Object selectUserid2 = sqlSession4.selectOne("selectUserid", 1);
            System.out.println(selectUserid2);
            sqlSession4.close();
            //其他修改
            System.out.println("*****************************其他修改(与原数据有关)--------------------------");
            SqlSession sqlSession5=sqlSessionFactory.openSession();
            User user = new User();
            user.setName("changzhaohai");
            user.setId(1);
            int update= sqlSession5.update("update",user);
            System.out.println("其他修改共修改了"+update+"条数据");
            sqlSession5.commit();
            sqlSession5.close();
            System.out.println("*****************************第四次查询--------------------------");
            //第四次查询
            SqlSession sqlSession6=sqlSessionFactory.openSession();
            Object selectUserid3 = sqlSession6.selectOne("selectUserid", 1);
            System.out.println(selectUserid3);
            sqlSession6.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
