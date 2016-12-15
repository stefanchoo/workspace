package com.africa.study.format;

/**
 * @author zhuhusheng
 * @date 2016/12/6
 */
public class StringUtils {
    public static void main(String[] args) {
        String y = "fdsfsefef";
        String x = "TransferOutLoaderReady2.71-1";
        System.out.println(y.split("\\.")[0]);
        System.out.println(Integer.parseInt(x.charAt(x.length() - 1) + ""));
    }
}
