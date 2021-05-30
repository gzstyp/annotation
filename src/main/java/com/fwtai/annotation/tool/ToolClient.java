package com.fwtai.annotation.tool;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class ToolClient{

    public static void responseJson(final String json,final HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(json);
            writer.flush();
        }catch (final IOException e){}finally{
            if(writer != null){
                writer.close();
            }
        }
    }

    public static String createJson(final int code,final String msg){
        final JSONObject json = new JSONObject(2);
        json.put("code",code);
        json.put("msg",msg);
        return json.toJSONString();
    }
}