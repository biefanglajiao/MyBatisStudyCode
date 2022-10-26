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
        User user1=sqlSession.selectOne("ifTableSelect",user);
        System.out.println(user1);
    }
    @After
    public  void  close(){
      sqlSession.close();
    }
}
