package com.poype.easyauth.core.repository;

import com.poype.easyauth.core.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleRepository {

    List<Role> queryRoleListByUserId(@Param("userId") String userId);
}
