package com.poype.easyauth.core.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class JwtParseDto {

    private String userId;

    private List<String> permissionNames;

    private String accessToken;

    private boolean isExpire;
}
