package com.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.UserDao;
import com.study.pojo.User;
import com.study.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)      //springboot事务只需要一个注解无需配置
    public void transfer(Integer sourceId, Integer targetId, Integer money) {
        User sourceUser = userDao.findById(sourceId);
        User targetUser = userDao.findById(targetId);
        sourceUser.setMoney(sourceUser.getMoney() - money);
        targetUser.setMoney(targetUser.getMoney() + money);
        userDao.updateUser(sourceUser);
        int i = 10 / 0;
        userDao.updateUser(targetUser);
    }

    @Override
    public PageInfo<User> findUserByPage(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<User> allUser = userDao.findAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(allUser);
        return pageInfo;
    }
}
