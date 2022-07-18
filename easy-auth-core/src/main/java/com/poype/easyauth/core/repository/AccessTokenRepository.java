package com.poype.easyauth.core.repository;

import com.poype.easyauth.core.model.AccessToken;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AccessTokenRepository {

    void save(AccessToken accessToken);
}
