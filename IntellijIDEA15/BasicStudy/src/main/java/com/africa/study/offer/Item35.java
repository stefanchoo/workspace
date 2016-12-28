package com.africa.study.offer;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 *
 * @author zhuhusheng
 * @date 2016/12/28
 */
public class Item35 {
    public static void main(String[] args) {
        String s = "dawdwdwdwrffefsefe";
        char c[] = s.toCharArray();
        System.out.println("第一个只出现一次的字符为：" + first(c));
    }

    public static char first(char c[]) {
        char tmp = 0;
        // Hash表，key 字符， value 出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                int count = map.get(c[i]);
                map.remove(c[i]);
                map.put(c[i], count + 1);
            } else {
                map.put(c[i], 1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                tmp = character;
                break;
            }
        }
        return tmp;
    }

}
