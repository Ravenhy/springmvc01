package com.pojo;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * @Author: wzy
 * @Date: 2024/10/28 16:10
 * 用户对象    封装从数据库回来的信息  实体类
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SmbmsUser {
    private Integer id; //id
    private String userCode; //用户编码
    private String userName; //用户名称
    private String userPassword; //用户密码
    private Integer gender;  //性别
    private String birthday;  //出生日期
    private String phone;   //电话
    private String address; //地址
    private Integer userRole;    //用户角色
    private Integer createdBy;   //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy;     //更新者
    private Date modifyDate;   //更新时间
}
