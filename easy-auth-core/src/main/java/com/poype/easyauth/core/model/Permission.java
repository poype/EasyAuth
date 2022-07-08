package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

@Setter
@Getter
@ToString
public class Permission implements GrantedAuthority {

    private int id;

    private String name;

    private String description;

    private String status;

    private Date createTime;

    private Date updateTime;

    @Override
    public String getAuthority() {
        return name;
    }
}
