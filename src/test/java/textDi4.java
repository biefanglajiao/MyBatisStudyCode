import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Sqlsession;
import org.example.yiduiyi.Card;
import org.example.yiduiyi.Person;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class textDi4 {
    @Test
    public void yiduiyi(){
        SqlSession sqlSession;
     String reserous="mybatis-config.xml";
        try {
            Reader reader= Resources.getResourceAsReader(reserous);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlSessionFactory.openSession();
            Person person = sqlSession.selectOne("selectone", 3);
            System.out.println(person);
            Card card = sqlSession.selectOne("selectbyid", 1);
            System.out.println(card);
            sqlSession.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    //todo settings问题
    @Test
    public void yiduiyi1(){
        SqlSession sqlSession;
        String reserous="mybatis-config.xml";
        try {
            Reader reader= Resources.getResourceAsReader(reserous);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlSessionFactory.openSession();
            Person person = sqlSession.selectOne("selectone1", 3);
            System.out.println(person);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
