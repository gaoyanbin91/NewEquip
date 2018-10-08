package com.ydong.newequip.model;

import java.io.Serializable;

/**
 * Created by Yanbin on 2018/9/21.
 * 描述:
 */
public class ResultBean implements Serializable {

    /**
     * msg : 修改成功
     * success : true
     */

    private String msg;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
