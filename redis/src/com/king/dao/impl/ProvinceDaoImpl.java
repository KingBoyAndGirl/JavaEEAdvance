package com.king.dao.impl;

import com.king.dao.ProvinceDao;
import com.king.domain.Province;
import com.king.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.dao.impl
 * @ClassName: ProvinceImol
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/6 19:51
 * @Version: 1.0
 */
public class ProvinceDaoImpl implements ProvinceDao {
    //1.声明成员变量
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql="select * from province";
        return template.query(sql,new BeanPropertyRowMapper<>(Province.class));
    }
}
