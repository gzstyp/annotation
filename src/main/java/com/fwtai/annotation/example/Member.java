package com.fwtai.annotation.example;

public final class Member{

    @AnField("kid")//todo 如果只有一个成员参数,一般参数名为 value
    private String id;

    private String name;

    private String remark;

    @AnMethod(value = "val",name = "name")
    public void getV(){

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }
}