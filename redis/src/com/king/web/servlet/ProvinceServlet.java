package com.king.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.king.domain.Province;
import com.king.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ProjectName: JavaEEAdvance
 * @Package: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 王团结
 * @Description: ${description}
 * @Date: 2019/8/6 19:59
 * @Version: 1.0
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.调用service查询
//        ProvinceServiceImpl service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
//        //2.序列化list为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);

        //1.调用service查询
        ProvinceServiceImpl service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        String json = service.findAllJson();

        System.out.println(json);
        //3.响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
