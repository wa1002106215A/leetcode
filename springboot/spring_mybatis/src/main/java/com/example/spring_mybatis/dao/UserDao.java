package com.example.spring_mybatis.dao;


import com.example.spring_mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserDao {
    @Select("select * from t_user where id=#{id}")
    public User getById(Integer id);
}
