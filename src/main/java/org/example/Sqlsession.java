package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/****
 *在编程中我们发现sqlsession的创建过程是重复的，所以创建此方法来模块化编程
 *
 */
public class Sqlsession {
    private  static SqlSession sqlSession;
    static {
        try {
          Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
       SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
     sqlSession=sqlSessionFactory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSession;
    }
}
