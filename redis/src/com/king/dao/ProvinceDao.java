package com.king.dao;

import com.king.domain.Province;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.dao.impl
 * @ClassName: ProvinceDao
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/6 19:48
 * @Version: 1.0
 */
public interface ProvinceDao {
    public List<Province> findAll();
}
