package com.king.dao.impl;

import com.king.dao.UserDao;
import com.king.domain.User;
import com.king.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.dao.impl
 * @ClassName: UserDaoImpl
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/3 16:33
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //1.定义SQL
        String sql="select * from user";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
}
