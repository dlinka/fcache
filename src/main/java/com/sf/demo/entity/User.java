package com.sf.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {

    private Integer userId;
    private String name;
    private Integer age;
    private LocalDateTime createTime;

}
