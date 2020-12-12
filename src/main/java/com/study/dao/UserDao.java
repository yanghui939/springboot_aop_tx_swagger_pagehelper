package com.study.dao;

import com.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> findAllUser();
    User findById(@Param("id") Integer id);
    int updateUser(User user);
}
