package com.fwtai.annotation.tool;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

public final class ToolEntity{

    public static Object createEntity(final HttpServletRequest request,final Class<?> clszz){
        final Field[] fields = clszz.getDeclaredFields();//获取所有的属性
        try {
            final Object object = clszz.newInstance();//实例化对象
            for(final Field field : fields){
                field.setAccessible(true);
                final Class<?> type = field.getType();
                final String typeName = type.getSimpleName();
                final String name = field.getName();
                switch (typeName){
                    case "Float":
                        final String f = request.getParameter(name);
                        if(f != null && f.length() >0){
                            field.set(object,Float.parseFloat(f));
                        }
                        break;
                    case "Double":
                        final String d = request.getParameter(name);
                        if(d != null && d.length() >0){
                            field.set(object,Double.parseDouble(d));
                        }
                        break;
                    case "Integer":
                        final String integer = request.getParameter(name);
                        if(integer != null && integer.length() >0){
                            field.set(object,Integer.parseInt(integer));
                        }
                        break;
                    case "Long":
                        final String l = request.getParameter(name);
                        if(l != null && l.length() >0){
                            field.set(object,Long.parseLong(l));
                        }
                        break;
                    default:
                        final String string = request.getParameter(name);
                        if(string != null && string.length() >0){
                            field.set(object,string);
                        }
                        break;
                }
            }
            return object;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从表单构建实体对象,做业务之前先做判断是否为空再处理业务
     * @param request
     * @param clszz 目标实体
     * @作者 田应平
     * @QQ 444141300
     * @创建时间 2021/5/30 11:50
    */
    public static <T> T getEntity(final HttpServletRequest request,final Class<T> clszz){
        final Field[] fields = clszz.getDeclaredFields();//获取所有的属性
        try {
            final T object = clszz.newInstance();//实例化对象
            for(final Field field : fields){
                field.setAccessible(true);
                final String type = field.getType().getSimpleName();
                final String name = field.getName();
                final String value = request.getParameter(name);
                switch (type){
                    case "Float":
                        if(value != null && value.length() >0){
                            field.set(object,Float.parseFloat(value));
                        }
                        break;
                    case "Double":
                        if(value != null && value.length() >0){
                            field.set(object,Double.parseDouble(value));
                        }
                        break;
                    case "Integer":
                        if(value != null && value.length() >0){
                            field.set(object,Integer.parseInt(value));
                        }
                        break;
                    case "Long":
                        if(value != null && value.length() >0){
                            field.set(object,Long.parseLong(value));
                        }
                        break;
                    default:
                        if(value != null && value.length() >0){
                            field.set(object,value);
                        }
                        break;
                }
            }
            return object;
        } catch (final Exception e){
            e.printStackTrace();
        }
        return null;
    }
}