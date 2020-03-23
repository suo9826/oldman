package com.springboot.bootcache.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {

    @RequestMapping(value = {"/","success","fair"})
    public String login(Model model)
    {
       // model.addAttribute("user",new User());
        return "login";
    }
    @RequestMapping("/password")
    public String password()
    {
        return "password";
    }

}
