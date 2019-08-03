package com.king.dao.impl;

import com.king.dao.UserDao;
import com.king.domain.User;
import com.king.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public User findUserByUsernameAndPassword(String name, String password) {
        try {
            String sql="select * from user where username=? and password= ? ";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),name,password);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(String id) {
        String sql="delete from user where id = ? ";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql="select * from user where id = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql="update user set name= ?, gender=?,age=?, address=?,qq=?,email=? where id = ? ";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql="select count(*) from user where 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params=new ArrayList<Object>();
        for(String key:keySet){

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                //有值
                //判断角色
                if(key.equals("User_Role")){
                    stringBuilder.append(" and "+key+" = ? ");
                    params.add(value);  //?条件的值
                }else{

                    stringBuilder.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");  //?条件的值
                }

            }
        }

        sql=stringBuilder.toString();

        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user where 1 = 1 ";
        StringBuilder stringBuilder = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params=new ArrayList<Object>();
        for(String key:keySet){

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value!=null && !"".equals(value)){
                //有值
                //判断角色
                if(key.equals("User_Role")){
                    stringBuilder.append(" and "+key+" = ? ");
                    params.add(value);  //?条件的值
                }else{

                    stringBuilder.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");  //?条件的值
                }
            }
        }

        //添加分页查询
        stringBuilder.append(" limit ?,? ");
        sql=stringBuilder.toString();

        //判断数据是否为空
        if(start<0){
            //添加分页查询参数值
            params.add(0);
            params.add(0);
            return  template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
        }

        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        return  template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
