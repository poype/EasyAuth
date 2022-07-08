package com.poype.easyauth.core.repository;

import com.poype.easyauth.core.model.Identification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface IdentificationRepository {

    Identification queryByUsername(@Param("username") String username);
}
