package com.fwtai.annotation.service;

import com.fwtai.annotation.entity.UserEntity;
import com.fwtai.annotation.tool.ToolClient;
import com.fwtai.annotation.tool.ToolEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService{

    public String register(final HttpServletRequest request){
        final String name = request.getParameter("name");
        final String password = request.getParameter("password");
        final String age = request.getParameter("age");

        final UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setAge(Integer.parseInt(age));
        final UserEntity entity = (UserEntity)ToolEntity.createEntity(request,UserEntity.class);
        final UserEntity user = ToolEntity.getEntity(request,UserEntity.class);
        return ToolClient.createJson(200,"操作成功");
    }
}