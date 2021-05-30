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