package com.dsy.service;

import com.dsy.entity.Borrow;
import com.dsy.utils.PageBean;
import org.apache.ibatis.annotations.Param;


/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.service
 */
public interface BorrowService {

    void borrow(Borrow borrow);

    PageBean<Borrow> findBorrowsByUserIdByPage(Integer userid, @Param(value = "page") Integer page);

    void returnBook(Integer borrowid);


}
