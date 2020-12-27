package com.zyk.tool;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //状态码：用于判断控制器方法是否处理成功，code=100表示成功，code=200表示失败
    private int code;
    //提示信息
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String, Object> extend=new HashMap<String, Object>();

    public static Msg success() {	//静态函数，初始化返回成功信息
        Msg result=new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }
    public static Msg fail() {		//静态函数，初始化返回失败信息
        Msg result=new Msg();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }
    public Msg add(String key, Object value) {		//用于向extend中添加信息
        this.getExtend().put(key, value);
        return this;//由于add方法返回this，因此该方法可以连用多次，如Msg.success().add("1",1).add(2,"2");
    }
    //get、set方法
    public int getCode() {return code;}
    public void setCode(int code) {this.code = code;}
    public String getMsg() {return msg;}
    public void setMsg(String msg) {this.msg = msg;}
    public Map<String, Object> getExtend() {return extend;}
    public void setExtend(Map<String, Object> extend) {this.extend = extend;}
}
