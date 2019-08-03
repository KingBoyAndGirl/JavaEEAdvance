package com.king.dao;

import com.king.domain.User;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.dao
 * @ClassName: UserDao
 * @Author: 王团结
 * @Description: 用户操作的DAO
 * @Date: 2019/8/3 16:31
 * @Version: 1.0
 */
public interface UserDao {

    public List<User> findAll();
}
