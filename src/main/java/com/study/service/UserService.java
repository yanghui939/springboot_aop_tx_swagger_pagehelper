package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<User> findAllUser();
    void transfer(Integer sourceId,Integer targetId,Integer money);
    PageInfo<User> findUserByPage(Integer pageIndex,Integer pageSize);
}
