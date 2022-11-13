package 多对多;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.duoduiduo.Orders;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class text {
    @Test
    public void duoduiduo(){//嵌套查询
        SqlSession sqlSession;
        String reserous="mybatis-config.xml";
        try {
            Reader reader= Resources.getResourceAsReader(reserous);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlSessionFactory.openSession();
            List<Orders> findorderbyid = sqlSession.selectList("findorderbyid", 1);
            System.out.println(findorderbyid);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    嵌套结果查询
@Test
public void duoduiduo2(){
    SqlSession sqlSession;
    String reserous="mybatis-config.xml";
    try {
        Reader reader= Resources.getResourceAsReader(reserous);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        sqlSession=sqlSessionFactory.openSession();
        List<Orders> findorderbyid = sqlSession.selectList("findorderbyid2", 3);
        System.out.println(findorderbyid);

        sqlSession.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
