package me.gacl.domain;

import mapper.IUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by keruyun on 2017/10/26.
 */
public class App {
    public static void main(String[] args) {
        String resource = "/config.xml";

        InputStream in = App.class.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();

        //使用xml配置
        String preparedStatement = "me.gacl.mapping.userMapper.getUser";
        User user = session.selectOne(preparedStatement,1);
        System.out.println(user);

        //使用注解配置
        IUser mapper = session.getMapper(IUser.class);
        User user2 = new User();
        user2.setId(1);
        user2.setName("a");
        User user1= mapper.selectUserById(user2);
        System.out.println(user1);

        List<User> userList = mapper.getAllUser();
        userList.forEach(System.out::println);

        //如果不commit则数据库无法更新
        session.commit();
        session.close();

    }
}
