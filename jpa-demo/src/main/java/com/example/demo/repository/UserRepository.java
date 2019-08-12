package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * 注意：
 * 1.这里这里是interface，不是class
 * 2.CrudRepository里面的泛型，第一个是实体类，第二个是主键的类型
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("from User where id =:id ")
    public User getUser(@Param("id") Integer id);
}