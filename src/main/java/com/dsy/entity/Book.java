package com.dsy.entity;

import java.util.Set;

public class Book {
    private Integer bookid;

    private String name;

    private Integer count;

    private Set<Borrow> bookBorrows;

    public Set<Borrow> getBookBorrows() {
        return bookBorrows;
    }

    public void setBookBorrows(Set<Borrow> bookBorrows) {
        this.bookBorrows = bookBorrows;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}