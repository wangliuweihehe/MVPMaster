package com.wlw.admin.mvp.net;

public interface ErrorStatus {
    /**
     * 响应成功
     */
    int SUCCESS=0;

    /**
     * 未知错误
     */
    int UNKNOWN_ERROR = 1002;

    /**
     * 服务器内部错误
     */
    int SERVER_ERROR = 1003;

    /**
     * 网络连接超时
     */
    int NETWORK_ERROR = 1004;

    /**
     * API解析异常（或者第三方数据结构更改）等其他异常
     */
    int API_ERROR = 1005;
}
