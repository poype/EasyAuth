package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Role {

    private int id;

    private String name;

    private String description;

    private int status;

    private List<Integer> permissionIdList;

    private Date createTime;

    private Date updateTime;
}
