import exception.NoUserException;
import mapper.IUser;
import me.gacl.domain.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keruyun on 2017/11/1.
 */
//初始化方法1
@RunWith(MockitoJUnitRunner.class)
public class AnnotationMockito {
    @Mock
    private IUser mockUser;

    //初始化方法2
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    //初始化方法3
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void runWithTest(){
        when(mockUser.addUser(anyString(),anyInt())).thenReturn(1);
        mockUser.addUser("c",18);
        verify(mockUser).addUser(anyString(),anyInt());
    }
    @Test(expected = NoUserException.class)
    public void answerTest() throws NoUserException{
        when(mockUser.selectUserByName(anyString())).thenAnswer(answer->{
            List<User> userList = new ArrayList<>(3);
            User user1 = new User();
            user1.setId(10);
            user1.setName("c");
            user1.setAge(28);
            userList.add(user1);
            Object[] arg = answer.getArguments();
            if (arg[0].equals("c"))
                return userList;
            else
                throw new NoUserException("没有找到name为:"+arg[0]+"的User对象");
        });
        mockUser.selectUserByName("c").forEach(System.out::println);
    }
}
