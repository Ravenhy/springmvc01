package com.utils;

/**
 * @Author: wzy
 * @Date: 2024/11/13 11:03
 * @Description: 返回结果类
 */
public class ResultJSON<T> {
    private Integer code;
    private String msg;
    private T data;
    public ResultJSON(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }
    public static <T> ResultJSON success(T data){
        return new ResultJSON(200,"操作成功",data);
    }
    public static ResultJSON success(){
        return new ResultJSON(200,"操作成功",null);
    }
    public static ResultJSON success(Integer code,String msg){
        return new ResultJSON(code,msg,null);
    }
    public static ResultJSON error(){
        return new ResultJSON(400,"操作失败",null);
    }
    public static ResultJSON error(Integer code,String msg){
        return new ResultJSON(code,msg,null);
    }





    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
