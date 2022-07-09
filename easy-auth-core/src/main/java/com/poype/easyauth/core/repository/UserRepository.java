package com.poype.easyauth.core.repository;

import com.poype.easyauth.core.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserRepository {

    User queryByUserId(@Param("userId") String userId);
}
