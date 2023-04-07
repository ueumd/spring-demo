package com.ueumd.tech.service.impl;

import com.ueumd.tech.dao.BookDao;
import com.ueumd.tech.dao.impl.BookDaoImpl;
import com.ueumd.tech.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    // 提供依赖对象对应的setter方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}