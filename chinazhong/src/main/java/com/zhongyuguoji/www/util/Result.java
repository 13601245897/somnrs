package com.zhongyuguoji.www.util;

public class Result {

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public Result() {
        super();
    }

    public Result(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
