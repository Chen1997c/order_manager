package com.blank.controller;

import com.blank.entity.User;
import com.blank.service.UUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    @Autowired
    private UUserService userService;


    @RequestMapping("/index.html")
    public String index() {
        return "public/index";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update() {
        userService.update(new User());
        return "success";
    }


}
