package com.king.web.servlet;

import com.king.domain.PageBean;
import com.king.domain.User;
import com.king.service.UserService;
import com.king.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 王团结
 * @Description: ${description}
 * @Date: 2019/8/3 22:07
 * @Version: 1.0
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");   //当前页码
        String rows = request.getParameter("rows"); //每页显示条数

        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if(rows == null || "".equals(rows)){
            rows="5";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2.调用查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb=service.finUserByPage(currentPage,rows,condition);

        //3.存入request
        request.setAttribute("pb",pb);
        //转发
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
