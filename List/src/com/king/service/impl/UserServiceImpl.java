package com.king.service.impl;

import com.king.dao.UserDao;
import com.king.dao.impl.UserDaoImpl;
import com.king.domain.PageBean;
import com.king.domain.User;
import com.king.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(id);
    }

    @Override
    public User finUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);

    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids!=null&& ids.length>0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(id);
            }
        }

    }

    @Override
    public PageBean<User> finUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //1.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);

        //2.计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;

        //3.判断当前页是否越界
        if(currentPage<=0){
            currentPage=1;
        }
        if(currentPage>=totalPage){
            currentPage=totalPage;
        }

        //4.创建空的PageBean对象
        PageBean<User> userPageBean = new PageBean<User>();
        //5.设置参数
        userPageBean.setCurrentPage(currentPage);
        userPageBean.setRows(rows);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPage(totalPage);


        //6.调用dao查询List集合
        //计算开始的记录索引
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows,condition);
        userPageBean.setList(list);

        return userPageBean;
    }
}
