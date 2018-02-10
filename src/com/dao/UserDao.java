package com.dao;

import com.domain.po.Pager;
import com.domain.po.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 27608 on 2018/1/14.
 */
public interface UserDao extends GenericDao<User,Integer> {
    /*
    查询是最麻烦的，根据业务逻辑确定，后期也能更改
     */
    User findById(Integer id);//通过ID查询
    User findByEmail(String email);//通过邮件查询
    User findByTel(String tel);//通过电话号码查询
    List<User> findByName(String name);//通过名字查询
    List<User> findAll(int isRef);//两种模式，传参1是复杂模式（取出User关联的所有对象的信息），传参0是简单模式（只取出User的基本信息）

    List<User> find(Map<String,Object> map);//分页查询（含条件查询、排序查询）

    Integer find_count(Map<String,Object> map);//获取分页查询时的总页数

    //Interface类型默认是public
    /*
        对数据库的操作无非就是增、删、改、查
     */
    int insert(User user);
    int update(User user);
    int delete(User user);//根据User删除
    int delete(Integer id);//根据ID删除
    /*
    增、删、改是比较好写的。
     */
}
