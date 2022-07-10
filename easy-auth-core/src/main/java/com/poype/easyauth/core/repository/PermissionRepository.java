package com.poype.easyauth.core.repository;

import com.poype.easyauth.core.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PermissionRepository {

    List<Permission> queryByIds(@Param("idList") List<Integer> idList);
}
