package com.poype.easyauth.core.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdUtil {

    public static String generate22Id() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase().substring(10);
    }

    public static String generate32Id() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static String generateBizId() {
        return time() + generate22Id();
    }

    public static String time() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
        return formatter.format(new Date());
    }
}