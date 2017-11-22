package mapper;

import me.gacl.domain.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by keruyun on 2017/10/26.
 */
@Repository("userMapper")
public interface IUser {
    @Insert("insert into users(name,age) values(#{name},#{age})")
    public int addUser(@Param("name") String name, @Param("age") int age);

    @Delete("delete from users where id=#{id}")
    public int deleteUserById(int id);

    @Select("select * from users")
   /* @Results(
            {
                    @Result(id = true, column = "id", property = "userId"),
                    @Result(column = "name", property = "userName"),
                    @Result(column = "age", property = "userAge"),
            })*/
    public List<User> getAllUser();

    @Select("select id ,name ,age from users where id=#{id} and name=#{name}")
    public User selectUserById(User user);

    @SelectProvider(type=SqlProvider.class,method="selectUserByName")
    public List<User> selectUserByName(String name);
}
