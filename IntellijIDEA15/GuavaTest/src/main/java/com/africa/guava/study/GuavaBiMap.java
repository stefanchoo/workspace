package com.africa.guava.study;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaBiMap {
    public static void main(String[] args) {
        BiMap<String, String> weekNameMap = HashBiMap.create();

        weekNameMap.put("星期一", "Monday");
        weekNameMap.put("星期二", "Tuesday");
        weekNameMap.put("星期三", "Wednesday");
        weekNameMap.put("星期四", "Thursday");
        weekNameMap.put("星期五", "Friday");
        weekNameMap.put("星期六", "Saturday");
        weekNameMap.put("星期日", "Sunday");

        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
    }
}
