package com.king.service;

import com.king.domain.User;

import java.util.List;

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
}
