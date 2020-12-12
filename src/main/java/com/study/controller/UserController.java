package com.study.controller;

import com.github.pagehelper.PageInfo;
import com.study.pojo.User;
import com.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "用户接口", tags = "用户接口")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/findAllUser")
    @ApiOperation(value = "查询所有用户的接口", tags = "查询所有用户的接口")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/transfer/{sourceId}/{targetId}/{money}")
    @ApiOperation(value = "转账接口", tags = "转账接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sourceId", value = "转账人id", required = true, example = "1"),
            @ApiImplicitParam(name = "targetId", value = "收账人id", required = true, example = "2"),
            @ApiImplicitParam(name = "money", value = "转账金额", required = true, example = "100")
    })
    public String transfer(@PathVariable("sourceId") Integer sourceId,
                           @PathVariable("targetId") Integer targetId,
                           @PathVariable("money") Integer money) {
        try {
            userService.transfer(sourceId, targetId, money);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findUserByPage/{pageIndex}/{pageSize}")
    @ApiOperation(value = "分页查询", tags = "分页查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "当前页码", required = true, example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, example = "1")
    })
    public PageInfo<User> findUserByPage(@PathVariable("pageIndex") Integer pageIndex,
                                 @PathVariable("pageSize") Integer pageSize) {
            PageInfo<User> pageInfo = userService.findUserByPage(pageIndex, pageSize);
        return pageInfo;
    }
}
