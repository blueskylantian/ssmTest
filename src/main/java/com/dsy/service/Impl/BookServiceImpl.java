package com.dsy.service.Impl;

import com.dsy.dao.BookMapper;
import com.dsy.dao.BorrowMapper;
import com.dsy.entity.Book;
import com.dsy.entity.Borrow;
import com.dsy.service.BookService;
import com.dsy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.service.Impl
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BorrowMapper borrowMapper;

    public Book findById(int bookid) {
        return bookMapper.selectByPrimaryKey(bookid);
    }

    public List<Book> findAll() {
        return bookMapper.queryAll();
    }

    public void borrow(int bookid, int userid) {
        Borrow borrow = new Borrow();
        borrow.setUserid(userid);
        borrow.setBookid(bookid);
        borrow.setTime(new Date());

        Book book = bookMapper.selectByPrimaryKey(bookid);
        if (book!=null&&book.getCount()>=1){
            bookMapper.reduceCount(bookid);
            borrowMapper.insert(borrow);
            System.out.println("图书："+book.getName()+"借阅成功");
        }else {
            assert book != null;
            System.out.println("图书："+book.getName()+"库存不足");
        }
    }

    public PageBean<Book> findByKey(String key, Integer page) {
        PageBean<Book> pageBean = new PageBean<Book>();
        pageBean.setPage(page);
        int totalCount = bookMapper.totalCountByKeyWords(key);
        pageBean.setTotalCount(totalCount);
        int pageSize = 5;
        pageBean.setPageSize(5);
        //封装总页数
        Double num;//向上取整
        num = Math.ceil((double) totalCount /pageSize);
        pageBean.setTotalPage(num.intValue());

        int start = (page-1)*pageSize;
        pageBean.setList(bookMapper.selectByKeyWords(key,start));

        return pageBean;
    }


}
