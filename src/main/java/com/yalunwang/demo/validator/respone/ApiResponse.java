package com.yalunwang.demo.validator.respone;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;


public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    private T data;


    public ApiResponse() {
    }


    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(0);
        apiResponse.setMsg("成功");
        apiResponse.setData(data);
        return apiResponse;
    }


    public static <T> ApiResponse<T> fail(int code, String msg) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiResponse)) return false;

        ApiResponse that = (ApiResponse) o;

        if (code != that.code) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }


}
