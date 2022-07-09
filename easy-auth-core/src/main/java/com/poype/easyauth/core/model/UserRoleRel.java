package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class UserRoleRel {

    private long id;

    private String userId;

    private int roleId;

    private int status;

    private Date createTime;

    private Date updateTime;
}
