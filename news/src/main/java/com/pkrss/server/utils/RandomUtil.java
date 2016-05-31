package com.pkrss.server.utils;

import java.util.Random;

public class RandomUtil {

    public static int getInt(int min, int max) {
        Random random = new Random(System.currentTimeMillis());
        int temp = random.nextInt(max) % (max - min + 1) + min;
        return temp;
    }
    
    public static String int2String(int i, int nums) {
        return String.format("%0"+nums+"d", i);
    }
    
    public static String getIntString(int min, int max, int nums) {
        int i = getInt(min,max);        
        return int2String(i, nums);
    }
    
    public static String getIntString(int nums) {
        Random random = new Random(System.currentTimeMillis());
        final char[] c = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        String ret = "";
        for(int i=0;i<nums;++i)
            ret += c[random.nextInt(10)];
        return ret;
    }

}
