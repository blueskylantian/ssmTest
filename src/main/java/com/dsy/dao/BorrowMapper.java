package com.dsy.dao;

import com.dsy.entity.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BorrowMapper {

    int insert(Borrow record);

    Borrow selectByPrimaryKey(Integer borrowid);

    void updateByPrimaryKey(Borrow record);

    List<Borrow> findBorrowsByUserId(@Param(value = "userid") Integer userid,@Param(value = "start") Integer start);

    int findBorrowsCountByUserId(Integer userid);

}