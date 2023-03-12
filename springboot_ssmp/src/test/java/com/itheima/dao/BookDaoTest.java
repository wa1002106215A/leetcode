package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testSave() {
        Book book=new Book();
        book.setName("SpringMVC");
        book.setType("计算机科学");
        book.setDescription("好");
        bookDao.insert(book);
    }
    @Test
    void testUpdate() {
        Book book=new Book();
        book.setId(3);
        book.setName("SpringMVC");
        book.setType("计算机科学");
        book.setDescription("测试");
        bookDao.updateById(book);

    }
    @Test
    void testDelete() {
        bookDao.deleteById(4);

    }
    @Test
    void testGetAll() {
        bookDao.selectList(null);

    }
    @Test
    void testGetPage() {
        IPage page=new Page(1,5);
        bookDao.selectPage(page,null);

    }
    @Test
    void testGetBy() {
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","Spring");
        bookDao.selectList(queryWrapper);

    }
}
