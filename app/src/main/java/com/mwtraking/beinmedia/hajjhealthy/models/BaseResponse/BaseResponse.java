package com.mwtraking.beinmedia.hajjhealthy.models.BaseResponse;

/**
 * Created by Mahmoud Waked
 */

public class BaseResponse {

    private boolean status;
    private String value;
    private String msg;
    private boolean key;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
}
