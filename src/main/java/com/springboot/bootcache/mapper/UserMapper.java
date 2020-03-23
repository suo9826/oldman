package com.springboot.bootcache.mapper;

import com.springboot.bootcache.bean.Old_Nur;
import com.springboot.bootcache.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public ArrayList<User> selectAll();

    @Select("select * from user where user_name=#{user_name}")
    public User selectByname(String user_name);

    @Insert("insert into user(user_name,user_password,user_email,user_phone,user_birth,user_sex) values(#{user_name},#{user_password},#{user_email},#{user_phone},#{user_birth},#{user_sex})")
    public void insert(User user);

    @Update("update user set user_email=#{user_email},user_sex=#{user_sex},user_phone=#{user_phone},user_birth=#{user_birth} where user_name=#{user_name}")
    public void update(User user);
    @Select("select * from user  where user_name=#{user_name} or user_email=#{user_email}")
    public User selectByuser(User user);
    @Update("update user set user_password=#{user_password} where user_name=#{user_name} or user_email=#{user_email}")
    public void updatePassword(User user);

}
