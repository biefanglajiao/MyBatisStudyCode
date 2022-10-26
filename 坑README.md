# 本文记录了遇到的一些坑
# 注意：<.>中.的使用是因为不加.不显示
## 关于“<resultmap.>”（见UserMapper.xml与TestFirstDemo）
` resultmap使用场景是数据库属性名和自定义类的属性名不一致时使用的。这样能使数据库和返回参数一致；`
<br>·错误时报错：”返回值为null“  {纯null}
<br>· 注：自定义类的getset方法的返回值错误也会返回为null{一般只有一项为null}
 <br> 注：数据库要与自定义类的编码一致：不然报编码不一致错误；
<br>
## 关于sqlsession中函数的形参问题
sqlSession = sqlSessionFactory.openSession();`<br>
User user = new User();<br>
user.setName("aaa");<br>
user.setId(4);<br>
int delete = sqlSession.delete("delete", <font color=red>user</font>);<br>
<br>*注：此处填user才是传入user对象数据 填“user”传入的是user这个字符串！！*
<br>会报传入数据类型错误
### 发现条件 ：
<font color=yellow>插入数据是user对象中的name值为“aa”，但是插入后显示为user（说明插入的数据是字符串“user”而没有传入user对象的值）</font>
## 关于if标签报 Cause: java.lang.NumberFormatException: For input string: "xxxx"
💥if标签里面的判空语句为test="x!=null and x!='' " (中间没有空格)