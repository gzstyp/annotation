package com.fwtai.annotation.controller;

import com.fwtai.annotation.service.UserService;
import com.fwtai.annotation.tool.ToolClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(final HttpServletRequest request,final HttpServletResponse response){

        final String json = userService.register(request);
        ToolClient.responseJson(json,response);
    }
}