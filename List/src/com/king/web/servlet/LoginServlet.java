package com.king.web.servlet;

import com.king.domain.User;
import com.king.service.UserService;
import com.king.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 王团结
 * @Description: ${description}
 * @Date: 2019/8/3 17:49
 * @Version: 1.0
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取数据
        Map<String, String[]> map = new HashMap<>(request.getParameterMap());
        //2.1获取用户填写的验证码
        String[] verifycodes = map.remove("verifycode");
        //3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        if ( verifycodes[0].equals("") || checkcode_server==null ||  !checkcode_server.equalsIgnoreCase(verifycodes[0])){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误");
            //跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.调用service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        //6.判断是否登录成功

        if(loginUser!=null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }else {
            //登录失败
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
