import com.dsy.dao.BookMapper;
import com.dsy.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dsy on 2018/7/23
 * Package PACKAGE_NAME
 */
public class BookTest extends BaseTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testFindBookById(){
        Book book = bookMapper.selectByPrimaryKey(1);
        System.out.println(book.getName());
    }

    @Test
    public void testDeleteById(){
        bookMapper.deleteByPrimaryKey(5);
    }

    @Test
    public void testQueryAll(){
        List<Book> list = bookMapper.queryAll();
        for (Book book :list){
            System.out.println(book.getName());
        }
    }

    @Test
    public void testinsert(){
        Book book = new Book();
        book.setCount(10);
        book.setName("编译原理");
        bookMapper.insert(book);
    }

    @Test
    public void testReduceBook(){
        bookMapper.reduceCount(8);

    }



}
