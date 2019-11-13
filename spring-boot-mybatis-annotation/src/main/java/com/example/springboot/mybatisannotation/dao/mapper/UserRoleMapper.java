package com.example.springboot.mybatisannotation.dao.mapper;


import com.example.springboot.mybatisannotation.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserRoleMapper {


    /*
     * 新增数据，并把主键绑定到UserRole实体类
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_role(user_id,role_id) values (#{userId},#{roleId})")
    int add(UserRole user);
}