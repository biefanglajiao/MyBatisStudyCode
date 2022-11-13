# 本文记录了遇到的一些坑
# 注意：<.>中.的使用是因为不加.不显示
# 关于“<resultmap.>”（见UserMapper.xml与TestFirstDemo）
##  resultmap使用场景是:<br>

> 1. 数据库属性名和自定义类的属性名不一致时使用的。这样能使数据库和返回参数一致；
> 2. 自定义返回参数映射<br>
>
> >eg: property="id" column="uid" <font color=yellow> property对应实体类 column对应数据库</font>

>
> <br>·错误时报错：”返回值为null“  {纯null}
> <br>· 注：自定义类的getset方法的返回值错误也会返回为null{一般只有一项为null}
>  <br> 注：数据库要与自定义类的编码一致：不然报编码不一致错误；
> <br>

## 关于sqlsession中函数的形参问题
> sqlSession = sqlSessionFactory.openSession();
> User user = new User();<br>
> user.setName("aaa");<br>
> user.setId(4);<br>
> int delete = sqlSession.delete("delete", <font color=red>user</font>);<br>
> <br>*注：此处填user才是传入user对象数据 填“user”传入的是user这个字符串！！*
> <br>会报传入数据类型错误
>
> ##### 如何发现的 ：
>
> <font color=yellow>插入数据是user对象中的name值为“aa”，但是插入后显示为user（说明插入的数据是字符串“user”而没有传入user对象的值）</font>


## 关于if标签报 Cause: java.lang.NumberFormatException: For input string: "xxxx"
💥if标签里面的判空语句为test="x!=null and x!='' " (中间没有空格)
## 关于foreach的一些

> - <font color=red>item</font>必须要有对应着结构中的  <font color=red>#{}</font>
> - <font color=red>collection</font>:中<br>
>   数组对应array；集合对应list；map对应map对象名。
> - <font color=red>index</font>:未知🕐

## 关于重写tostring
object类里的toString只是把字符串的直接打印，数字的要转化成字符再打印，<font color=red>而对象，则直接打印该对象的hash码</font><br>
只有重写后才能在sout语句中看到想要的格式的结果·1·

## 文件中的实体类多的时候,在引用的时候 记得写入全类名
## 数据库列创建时 要注意改写编码方式为utf-8不然无法输入中文
## xml标签是有先后顺序的  比如：

> ### <·configuration>中先后顺序必须为：
>
> (properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?)"

