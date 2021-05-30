package com.fwtai.annotation.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Annotaions{

    public static void main(final String[] args){
        final Class<Member> aClass = Member.class;//通过字节码获取
        try {
            Class.forName("com.fwtai.annotation.example.Member");//也是可以的
        } catch (final Exception e) {
            e.printStackTrace();
        }
        //获取对象的所有方法
        final Method[] methods = aClass.getMethods();

        for(final Method method : methods){
            //1.遍历方法是否有该自定义的注解
            final boolean present = method.isAnnotationPresent(AnMethod.class);//
            if(present){
                final AnMethod table = method.getAnnotation(AnMethod.class);
                //2.分析注解里的参数
                System.out.println(method.getName() + ":" + table);
            }else{
                System.out.println(method.getName() + ",该方法没有自定义注解");
            }
        }
        final Field[] fields = aClass.getDeclaredFields();
        for(final Field field : fields){
            final boolean present = field.isAnnotationPresent(AnField.class);
            if(present){
                final AnField table = field.getAnnotation(AnField.class);
                System.out.println(field.getName() + ":"+table.value());//todo 如果只有一个成员参数,一般参数名为 value
            }else{
                System.out.println(field.getName() + ",该属性没有自定义注解");
            }
        }
    }
}