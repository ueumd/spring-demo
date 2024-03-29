package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    /**
     * 自动装配
     * 问题：无法自动装配。找不到 'BookDao' 类型的 Bean
     * 1. 实际不影响使用，但是会有红线！！！
     * 解决：
     *  1. @Autowired(required = false)
     *  2. 设置-> 检查 -> spring -> code -> Spring Bean组件中的自动装配不正确 改成 警告
     */
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }


    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        return  bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
