package com.king.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.king.dao.ProvinceDao;
import com.king.dao.impl.ProvinceDaoImpl;
import com.king.domain.Province;
import com.king.jedis.test.JedisPoolUtils;
import com.king.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.service.impl
 * @ClassName: ProvinceImpl
 * @Author: 王团结
 * @Description:
 * @Date: 2019/8/6 19:52
 * @Version: 1.0
 */
public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2.判断 province_json 数据是否为null
        if (province_json == null || province_json.length()==0){
            //redis中没有数据
            System.out.println("redis中没有数据，查询数据库。。");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //2.3将json数据存入redis
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存。。");
        }

        //3.

        return province_json;
    }
}
