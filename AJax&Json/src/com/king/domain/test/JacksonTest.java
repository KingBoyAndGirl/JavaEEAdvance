package com.king.domain.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.king.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: com.king.domain.test
 * @ClassName: JacksonTest
 * @Author: 王团结
 * @Description: 测试Jackson
 * @Date: 2019/8/6 14:10
 * @Version: 1.0
 */
public class JacksonTest {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(24);
        p.setGender("男");

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*

            转换方法
                writeValue(参数1，obj):
		                    参数1：
		                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
		                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
		                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json对象
         */

//        String json = mapper.writeValueAsString(p);
//        System.out.println(json);

        //writeValue，将数据写到D://a.txt文件中

        mapper.writeValue(new File("d://a.txt"),p);
    }

    @Test
    public void test2() throws IOException {
        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(24);
        p.setGender("男");
        p.setBerthday(new Date());

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }

    @Test
    public void test3() throws IOException {
        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(24);
        p.setGender("男");
        p.setBerthday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(24);
        p1.setGender("男");
        p1.setBerthday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(24);
        p2.setGender("男");
        p2.setBerthday(new Date());

        List<Person> list = new ArrayList<>();

        list.add(p);
        list.add(p1);
        list.add(p2);

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Test
    public void test4() throws IOException {
        //1.创建map对象
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }
}

