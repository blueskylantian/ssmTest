import com.dsy.entity.User;
import com.dsy.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dsy on 2018/7/24
 * Package PACKAGE_NAME
 */
public class Test_UserService  extends BaseTest{

    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        User user = userService.findByUserId(4);
        System.out.println(user.getState());
        userService.updateState(user);
        System.out.println(user.getState());
    }
}
