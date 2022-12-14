import org.apache.ibatis.session.SqlSession;
import org.example.Sqlsession;
import org.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user5=sqlSession.selectOne("trimTableSelect",user);

        System.out.println("user1:  "+user1);
        System.out.println("user2:  "+user2);
  System.out.println("user3:  "+user3);
        System.out.println("user4:  "+user4);
        System.out.println("user5:  "+user5);
    }
    @Test
    public  void  update(){
        User user=new User();
        user.setName("常兆海");
        user.setId(7);

        int update = sqlSession.update("setupdate", user);
        User user1=sqlSession.selectOne("sqlTableSelect",user);
        System.out.println("成功更新"+update+"条数据：为：  "+user1);
        sqlSession.commit();
    }
    @Test
    public  void  update1(){
        User user=new User();
        user.setName("常兆海6");
        user.setId(6);

        int update = sqlSession.update("tirmupdate", user);
        User user1=sqlSession.selectOne("sqlTableSelect",user);
        System.out.println("成功更新"+update+"条数据：为：  "+user1);
        sqlSession.commit();
    }
    @Test
    public void foeeachselect(){
        System.out.println("array:");
        Integer[] integers={1,3,5};
        List<User> foreacheSelectShuzu = sqlSession.selectList("foreacheSelectShuzu", integers);
        for (User user : foreacheSelectShuzu) {
            System.out.println(user);
        }
        System.out.println("list：");
        List<Integer> arr =new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);

        List<User> foreacheSelectList = sqlSession.selectList("foreacheSelectlist", arr);
        for (User user : foreacheSelectList) {
            System.out.println(user);
        }
        System.out.println("map：");
        List<Integer> arr1 =new ArrayList<>();
        arr1.add(1);
        arr1.add(3);
        arr1.add(5);
        Map map=new HashMap<>();
        map.put("ids",arr1);
        List<User> foreacheSelectMap = sqlSession.selectList("foreacheSelectMap", map);
        for (User user : foreacheSelectMap) {
            System.out.println(user);
        }

    }
    @After
    public  void  close(){
      sqlSession.close();
    }
}
