package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class Permission {

    private int id;

    private String name;

    private String description;

    private String status;

    private Date createTime;

    private Date updateTime;
}
