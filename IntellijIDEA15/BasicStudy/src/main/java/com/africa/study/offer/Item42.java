package com.africa.study.offer;

import org.apache.commons.lang.StringUtils;

/**
 * 翻转单词顺序
 *
 * @author zhuhusheng
 * @date 2016/12/29
 */
public class Item42 {
    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(StringUtils.reverse(s));
        System.out.println(reverseSentence(s));
    }

    public static String reverseSentence(String s) {
        char c[] = s.toCharArray();
        // 先将整个字符组翻转
        reverse(c, 0, c.length - 1);

        // 再翻转每一个单词
        int lengthOfTerm = 0;  // 单词的长度
        for (int i = 0; i < c.length; i++) {
            if(c[i] == ' ') {
                int end = i - 1;
                int start = end - lengthOfTerm + 1;
                reverse(c, start, end);
                lengthOfTerm = 0;
            } else {
                lengthOfTerm++;
            }
        }
        return new String(c);
    }

    public static void reverse(char c[], int start, int end) {
        if (start == end) {
            return;
        }
        while (start < end) {
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start++;
            end--;
        }
    }
}
