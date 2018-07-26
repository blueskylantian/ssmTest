package com.dsy.service;

import com.dsy.entity.Book;
import com.dsy.utils.PageBean;

import java.util.List;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.service
 */
public interface BookService {

    Book findById(int bookid);

    List<Book> findAll();

    void borrow(int bookid,int userid);

    PageBean<Book> findByKey(String key, Integer page);
}
