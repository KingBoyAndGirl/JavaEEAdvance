package com.king.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 王团结
 * @Description: ${description}
 * @Date: 2019/8/6 14:57
 * @Version: 1.0
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名
        String username = request.getParameter("username");


        //2.调用service层判断用户名是否存在

        //期望服务器响应回的数据格式：{"userExit"：true,"msg":"此用户太受欢迎，请更换一个"}
        //                          {"userExit"：false,"msg":"用户名可用"}
        response.setContentType("text/html;charset=utf-8");
        Map<String, Object> map = new HashMap<>();


        if("tom".equals(username)){
            //存在
            map.put("userExit",true);
            map.put("msg","此用户太受欢迎，请更换一个");
        }else {
            //不存在
            map.put("userExit",false);
            map.put("msg","用户名可用");
        }

        //将map转为json，并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
