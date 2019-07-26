package com.mp.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/7/26 10:47
 * @Version 1.0
 */
@Data
public class User {

    //ID
    private  Long id;
    //姓名
    private  String name;
    //年龄
    private  Integer age;
    //邮箱
    private String email;
    //直属上级
    private Long managerId;
    // 创建时间
    private LocalDateTime createTime;
}
