package com.africa.study.offer;

/**
 * 替换空格
 *
 * @author zhuhusheng
 * @date 2016/12/22
 */
public class Item04 {
    public static void main(String[] args) {
        String s = "Better Life, Better Work.";
        char c_old[] = s.toCharArray();
        char c_new[] = new char[100];
        System.arraycopy(c_old, 0, c_new, 0, c_old.length);
        System.out.println(replaceBlank(c_new, c_old.length));
        System.out.println(javaReplace(s));
    }

    public static String replaceBlank(char[] arrays, int length) {
        int blankNum = 0;
        for (int i = 0; i < length; i++) {
            if(arrays[i] == ' ')  blankNum++;
        }
        int newArraysLength = length + 2 * blankNum;   // 新的数组长度
        int i = length - 1;                            // old
        int j = newArraysLength - 1;                   // new
        while(i >= 0 && j >= 0) {
            if(arrays[i] != ' ') {
                arrays[j--] = arrays[i];
            } else {
                arrays[j--] = '0';
                arrays[j--] = '2';
                arrays[j--] = '%';
            }
            i--;
        }
        return new String(arrays);
    }

    public static String javaReplace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
