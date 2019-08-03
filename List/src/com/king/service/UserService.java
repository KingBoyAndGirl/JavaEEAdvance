package com.king.service;

import com.king.domain.PageBean;
import com.king.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.service
 * @ClassName: UserService
 * @Author: 王团结
 * @Description: 用户管理的业务接口
 * @Date: 2019/8/3 16:29
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 登录功能
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 保存user
     * @param user
     */
    void addUser(User user);

    /**
     * 删除user
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User finUserById(String id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> finUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
