package com.africa.study.ASSII2String;

/**
 * @author zhuhusheng
 * @date 2016/9/8
 */
public class ASSII2Sting {
    public static void main(String[] args) {
//        String barcode = "BK0YF00A10050006735927C0012!";  // 17位，这个就有点麻烦了
//        System.out.println(String3Assii(barcode));
//        System.out.println(Assii2String(String3Assii(barcode)));
//        System.out.println(Assii2String("!"));
        System.out.println(Assii2String("14"));
    }


    private static String Assii2String(String assii) {
        String[] chars = assii.split(" ");
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            System.out.println(chars[j] + ":" + (char) Integer.parseInt(chars[j]));
            result.append((char) Integer.parseInt(chars[j]));
        }
        return result.toString();
    }

    private static String String3Assii(String str) {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i=0; i < chars.length; i++) {
            System.out.println(chars[i] + ":" + (int)chars[i]);
            result.append((int)chars[i] + " ");
        }
        return result.toString().trim();
    }
}
