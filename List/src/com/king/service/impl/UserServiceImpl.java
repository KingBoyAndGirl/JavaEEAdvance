package com.king.service.impl;

import com.king.dao.UserDao;
import com.king.dao.impl.UserDaoImpl;
import com.king.domain.User;
import com.king.service.UserService;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.service.impl
 * @ClassName: UserServiceImpl
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/3 16:30
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
