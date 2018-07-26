import com.dsy.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dsy on 2018/7/23
 * Package test_service
 */
public class TestBookService extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void borrow(){
        bookService.borrow(1,2);
    }
}
