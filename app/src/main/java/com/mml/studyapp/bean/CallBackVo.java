package com.mml.studyapp.bean;

/**
 * 说明：基础实体类
 * 作者： MLing
 * 邮箱：mamenglingkl1314@163.com
 * 创建时间 ：2017/6/9 17:15.
 */

public class CallBackVo<T> {
    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
