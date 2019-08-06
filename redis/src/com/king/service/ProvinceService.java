package com.king.service;

import com.king.domain.Province;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.service
 * @ClassName: ProvinceService
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/6 19:51
 * @Version: 1.0
 */
public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
