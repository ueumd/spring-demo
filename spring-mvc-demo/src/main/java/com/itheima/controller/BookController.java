package com.itheima.controller;

import com.itheima.common.exception.SystemException;
import com.itheima.common.util.Code;
import com.itheima.common.util.Result;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

   @Autowired
   private BookService bookService;

   @PostMapping("/save")
   public boolean save(@RequestBody Book book) {
       return bookService.save(book);
   }

   @PostMapping("/update")
   public boolean update(@RequestBody Book book) {
       return bookService.update(book);
   }

   @GetMapping("/delete/{id}")
   public boolean delete(@PathVariable Integer id) {
       return bookService.delete(id);
   }

    @GetMapping("/getById/{id}")
   public Book getById(@PathVariable Integer id) {
       return bookService.getById(id);
   }

    @GetMapping("/getBookById/{id}")
    public Result getBookById(@PathVariable Integer id) {

       int i = 1/0;

       Book book = bookService.getById(id);
       Integer code  = book != null ? Code.GET_OK : Code.GET_ERR;
       String msg = book != null ? "ok" : "数据查询失败！";
       return new Result(book, code, msg);
    }

    /**
     * 异常处理测试
     * @param id
     * @return
     */
    @GetMapping("/getBookByIdExcep/{id}")
    public Result getBookByIdExcep(@PathVariable Integer id) {
        // 这样一个一个try 很麻烦，封装到ProjectExceptionAdvice.java
        try {
            int i = 1 /0;
        } catch (ArithmeticException e) {
            throw new SystemException(666, "服务器异常", e);
        }

        Book book = bookService.getById(id);
        Integer code  = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "ok" : "数据查询失败！";
        return new Result(book, code, msg);
    }

    @GetMapping("/getAlll")
   public List<Book> getAlll() {
       return bookService.getAll();
   }

    @GetMapping("/getAllBook")
    public Result getAllBook() {
        List<Book> bookList = bookService.getAll();
        Integer code  = bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "ok" : "数据查询失败！";
        return new Result(bookList, code, msg);
    }
}


