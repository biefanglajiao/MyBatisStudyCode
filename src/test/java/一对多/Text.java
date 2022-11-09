package 一对多;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.yiduiyi.Card;
import org.example.yiduiyi.Person;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/****、
 * 订单系统涉及一对多 ；
 * 一个人里有多哥订单
 */

public class Text {
    @Test
    public void yiduiyi(){
        SqlSession sqlSession;
        String reserous="mybatis-config.xml";
        try {
            Reader reader= Resources.getResourceAsReader(reserous);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlSessionFactory.openSession();
            List<Object> findorders = sqlSession.selectList("findorders", 1);
            System.out.println(findorders);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
