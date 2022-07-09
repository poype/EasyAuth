package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class User {

    private String id;

    private int status;

    private String nickName;

    private Date createTime;

    private Date updateTime;

}
