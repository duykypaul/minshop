package com.duykypaul.core.common.utils;

public class SessionUtil {
    private static SessionUtil sessionUtil = null;

    public static SessionUtil getInstance() {
        if(sessionUtil == null){
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }
}
