import com.dsy.dao.UserMapper;
import com.dsy.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by dsy on 2018/7/22
 * Package PACKAGE_NAME
 */
public class UserTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() throws Exception{
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUsername());
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("小明");
        userMapper.insert(user);
    }

    @Test
    public void testLogin(){
        User user = userMapper.findByName("111");
        System.out.println(user.getUsername());
    }


}
