import mapper.IUser;
import me.gacl.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;

import static org.mockito.Mockito.*;
/**
 * Created by keruyun on 2017/11/1.
 */
public class MockTest {
    @Test
    public void testMock() {
        IUser mockUser = mock(IUser.class);

        User user1 = new User();
        user1.setId(1);
        user1.setName("c");
        user1.setAge(23);

        User user2 = new User();
        user2.setId(2);
        user2.setName("a");
        user2.setAge(27);
        when(mockUser.selectUserById(any())).thenReturn(user1).thenReturn(user2);

        //when(mockUser.selectUserById(anyInt())).thenReturn(user2);
        //when(mockUser.selectUserById(anyInt())).thenThrow(new RuntimeException("mocktio thenThrow"));
        //Assert.assertEquals("mock equal",user1,mockUser.selectUserById(1));

       // verify(mockUser,times(1)).selectUserById(1);
       // verify(mockUser).selectUserById(Matchers.eq(1));

    }
}
