package com.wlw.admin.mvp.net;

import android.net.ParseException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ExceptionHandle {
    public static String handleException(Throwable e) {
        e.printStackTrace();
        int errorCode = ErrorStatus.UNKNOWN_ERROR;
        String errorMsg = "请求失败，请稍后重试";
        if (e instanceof SocketTimeoutException) {//网络超时
            errorMsg = "网络连接异常";
            errorCode = ErrorStatus.NETWORK_ERROR;
        } else if (e instanceof ConnectException) { //均视为网络错误
            errorMsg = "网络连接异常";
            errorCode = ErrorStatus.NETWORK_ERROR;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //均视为解析错误
            errorMsg = "数据解析异常";
            errorCode = ErrorStatus.SERVER_ERROR;
        } else if (e instanceof UnknownHostException) {
            errorMsg = "网络连接异常";
            errorCode = ErrorStatus.NETWORK_ERROR;
        } else if (e instanceof IllegalArgumentException) {
            errorMsg = "参数错误";
            errorCode = ErrorStatus.SERVER_ERROR;
        } else {//未知错误
            errorMsg = "未知错误";
            errorCode = ErrorStatus.UNKNOWN_ERROR;
        }
        return errorMsg;
    }
}
