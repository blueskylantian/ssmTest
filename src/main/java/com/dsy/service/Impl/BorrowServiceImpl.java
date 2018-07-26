package com.dsy.service.Impl;

import com.dsy.dao.BookMapper;
import com.dsy.dao.BorrowMapper;
import com.dsy.entity.Borrow;
import com.dsy.service.BorrowService;
import com.dsy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.service.Impl
 */
@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookMapper bookMapper;

    public void borrow(Borrow borrow) {
        borrowMapper.insert(borrow);
        //借出后对应书本库存-1
        bookMapper.reduceCount(borrow.getBookid());
    }

    public PageBean<Borrow> findBorrowsByUserIdByPage(Integer userid, Integer page) {
        PageBean<Borrow> pageBean = new PageBean<Borrow>();
        pageBean.setPage(page);
        int pageSize = 8;
        pageBean.setPageSize(pageSize);
        int totalCount = borrowMapper.findBorrowsCountByUserId(userid);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        Double num;//向上取整
        num = Math.ceil((double) totalCount /pageSize);
        pageBean.setTotalPage(num.intValue());
        int start = (page-1)*pageSize;
        pageBean.setList(borrowMapper.findBorrowsByUserId(userid,start));
        return pageBean;
    }

    public void returnBook(Integer borrowid) {
        Borrow borrow = borrowMapper.selectByPrimaryKey(borrowid);
        borrow.setBstate(1);
        borrowMapper.updateByPrimaryKey(borrow);
        //还书后对应书本库存+1
        bookMapper.addCount(borrow.getBookid());
    }

}
