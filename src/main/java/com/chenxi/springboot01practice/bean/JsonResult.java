package com.chenxi.springboot01practice.bean;

public class JsonResult {
    private long total;
    private String message;
    private boolean status;
    private Object data;
    public JsonResult(){
        this("", true);
    }
    public JsonResult(String msg, boolean status){
        this(0, msg, null, true);
    }
    public JsonResult(long total, Object data){
        this(total, "", data, true);
    }
    public JsonResult(long total, String msg, Object data){
        this(total, msg, data, true);
    }
    public JsonResult(long total, String msg, Object data, boolean status){
        this.total = total;
        this.message = msg;
        this.status = status;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
