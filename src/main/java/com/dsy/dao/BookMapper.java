package com.dsy.dao;

import com.dsy.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    void deleteByPrimaryKey(Integer bookid);

    int insert(Book record);

    Book selectByPrimaryKey(Integer bookid);

    List<Book> queryAll();

    void reduceCount(@Param("bookid") int bookid);

    List<Book> selectByKeyWords(@Param(value = "key") String key,@Param(value = "start") Integer start);

    void addCount(Integer bookid);

    int totalCountByKeyWords(@Param(value = "key") String key);

}