package com.example.springboot.mybatisannotation.dao.mapper;


import com.example.springboot.mybatisannotation.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /*
    * 查询 所有用户
    */
    @Select("SELECT * FROM user ")
    List<User> queryAllUsers();


    /*
     * 新增数据，并把主键绑定到User实体类
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into User(name,password) values (#{name},#{password})")
    int add(User user);
}