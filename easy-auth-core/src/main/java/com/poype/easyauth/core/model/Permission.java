package com.poype.easyauth.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Getter
@ToString
public class Permission implements GrantedAuthority {

    private int id;

    private String name;

    private String description;

    private int status;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
