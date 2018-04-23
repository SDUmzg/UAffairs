package com.alearner.mapper.postgresql;


import com.alearner.entity.postgresql.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsersMapper {

    List<Users> findAll();
    Users findOne(@Param(value = "id") int id);
}
