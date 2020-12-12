package com.study.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户对象")
public class User {
    @ApiModelProperty(name = "id", value = "自增主键", example = "1")
    private Integer id;
    @ApiModelProperty(name = "name", value = "姓名", example = "张三")
    private String name;
    @ApiModelProperty(name = "money", value = "金额", example = "100")
    private Integer money;
}
