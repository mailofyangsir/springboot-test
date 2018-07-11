package com.core.util;

/**
 * Copyright
 * FileName: Result
 * Description:
 * :
 *
 * @author sir
 * @create 2018/7/11 23:15
 * @since 1.0.0
 */
public class Result {
    public static final int fail = -1;
    public static final int success = 0;


    private int code;
    private String msg;
    private Object data;

    public Result() {
    }


    public static Result getResult(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result getResult(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
