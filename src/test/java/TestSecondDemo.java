import org.apache.ibatis.session.SqlSession;
import org.example.Sqlsession;
import org.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSecondDemo {
    /***
     * 在所有程序的运行中；我们发现程序要经历创建，运行，结束 三个过程
     * 所以使用注释
     * @before 创建sqlsession
     * @test   具体代码使用语句
     * @after  关闭
     * 以此来极大程度上降低代码的重复量
     */
    SqlSession sqlSession;//在三个结构中都要使用的到
    @Before
        public void getsqlsession(){
         sqlSession =Sqlsession.getSqlSession();
    }
    @Test
    public void  selectifTableSql(){
        User user=new User();

        user.setId(7);
        user.setName("czhd");
        User user1=sqlSession.selectOne("sqlTableSelect",user);
        User user2=sqlSession.selectOne("ifTableSelect1",user);
        User user3=sqlSession.selectOne("ifTableSelect2",user);
        User user4=sqlSession.selectOne("WhereTableSelect",user);

        System.out.println("user1:  "+user1);
        System.out.println("user2:  "+user2);
  System.out.println("user3:  "+user3);
        System.out.println("user4:  "+user4);
    }
    @After
    public  void  close(){
      sqlSession.close();
    }
}
