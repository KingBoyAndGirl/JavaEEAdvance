package com.king.jedis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.jedis.test
 * @ClassName: JedisPoolUtils
 * @Author: 王团结
 * @Description: JedisPool工具类，加载配置文件，配置连接池的参数，提供获取连接的方法
 * @Date: 2019/8/6 18:37
 * @Version: 1.0
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {

        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建Properties对象
        Properties properties = new Properties();
        //关联文件
        try {
            assert is != null;
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据，设置到JedisPoolConfig中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //初始化JedisPool
        jedisPool=new JedisPool(config,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }


    /**
     * 获取连接方法
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
