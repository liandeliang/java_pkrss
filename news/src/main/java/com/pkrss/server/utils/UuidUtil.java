package com.pkrss.server.utils;

import java.util.UUID;

public class UuidUtil {

    public static String getUuid() {
       UUID uuid = UUID.randomUUID(); 
        return uuid.toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        String ss = getUuid();
        System.out.println(ss);
    }
}
