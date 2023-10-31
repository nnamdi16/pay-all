package com.nnamdi.payall.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public enum AppUtil {
    INSTANCE;

    public static  final Logger LOGGER = LoggerFactory.getLogger(AppUtil.class);

    AppUtil() {

    }

    public static boolean stringIsNullOrEmpty(String arg){
        if (arg==null) return true;
        return (arg.isEmpty()) || (arg.trim().isEmpty());
    }
}
