package com.chaos.vo;

public class ResultVo {

    //1：成功
    private int code;
    private String desc;
    private Object data;

    public ResultVo(Object data) {
        this.code = 1;
        this.desc = "成功";
        this.data = data;
    }

    public ResultVo(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
