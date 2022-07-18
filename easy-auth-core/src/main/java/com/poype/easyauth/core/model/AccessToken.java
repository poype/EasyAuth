package com.poype.easyauth.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
public class AccessToken {

    private long id;

    private String userId;

    private String accessToken;

    private List<String> permissions;

    private int status;

    private Date expiresAt;

    private Date createTime;

    private Date updateTime;
}
