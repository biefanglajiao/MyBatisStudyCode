package 缓存机制;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.User;
import org.example.duoduiduo.Orders;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class 一级缓存 {
    /****
     * 对user表查询应证一级缓存
     */
    @Test
    public void duoduiduo(){//嵌套查询
        SqlSession sqlSession;
        String reserous="mybatis-config.xml";
        try {
            Reader reader= Resources.getResourceAsReader(reserous);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlSessionFactory.openSession();
            System.out.println("*****************************第一次查询--------------------------");
            //第一次查询
            Object selectUserid = sqlSession.selectOne("selectUserid", 1);
            System.out.println(selectUserid);

            System.out.println("*****************************第二次查询--------------------------");
            //第二次查询
            Object selectUserid1 = sqlSession.selectOne("selectUserid", 1);
            System.out.println(selectUserid1);
            //其他修改
//            System.out.println("*****************************其他修改--------------------------");
//            int insert = sqlSession.insert("insert", "这是其他修改");
//            System.out.println("其他修改共修改了"+insert+"条数据");

            System.out.println("*****************************第三次查询--------------------------");
            //第三次查询
            Object selectUserid2 = sqlSession.selectOne("selectUserid", 1);
            System.out.println(selectUserid2);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
