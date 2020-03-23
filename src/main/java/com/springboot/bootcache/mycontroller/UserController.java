package com.springboot.bootcache.mycontroller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/selectUser")
    public User selectUser(HttpServletRequest request)
    {
        String user_name = (String) request.getSession().getAttribute("user_name");
        User user = userService.selectByname(user_name);
        System.out.println("user》》》》"+user);

       return user;

    }

    @ResponseBody
    @GetMapping("/updateUser")
    public String updateUser(User user)
    {

        userService.uodate(user);
        return "1";
    }
    //更新密码的
    @ResponseBody
    @GetMapping("/updatePassword")
    public String updatePassword(User user) {
        ArrayList<User> users = userService.selectAll();
        for (User u : users) {
            if (u.getUser_name().equals(user.getUser_name())) {
                if (u.getUser_email().equals(user.getUser_email())) {
                    userService.updatePassword(user);
                    System.out.println(0);
                    return "0";
                }
                System.out.println(2);
                return "2";
            }
            System.out.println(1);
            return "1";
        }
        return "login";
    }

}
