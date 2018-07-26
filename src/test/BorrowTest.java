import com.dsy.dao.BorrowMapper;
import com.dsy.entity.Borrow;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by dsy on 2018/7/23
 * Package PACKAGE_NAME
 */
public class BorrowTest extends BaseTest {

    @Autowired
    private BorrowMapper borrowMapper;


    @Test
    public void testInsertBorrow(){
        Borrow borrow = new Borrow();
        borrow.setBookid(2);
        borrow.setUserid(1);
        borrow.setTime(new Date());
        borrowMapper.insert(borrow);
    }





}
