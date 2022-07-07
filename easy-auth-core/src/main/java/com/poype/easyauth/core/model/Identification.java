package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Identification {

    private long id;

    private long userId;

    private String status;

    private String loginId;

    private String password;

    private Date createTime;

    private Date updateTime;
}
