package com.king.dao;

import com.king.domain.User;

import java.util.List;
import java.util.Map;

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

    User findUserByUsernameAndPassword(String name, String password);

    void add(User user);

    void delete(String id);

    User findUserById(int parseInt);

    void update(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
