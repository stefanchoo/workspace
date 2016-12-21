package com.africa.study.annotation;

/**
 * @author zhuhusheng
 * @date 2016/12/21
 */
@NameScanner
public class NameScannerTest {

    @NameScanner
    private String name;

    @NameScanner
    private int age;

    @NameScanner
    public String getName() {
        return this.name;
    }

    @NameScanner
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("--finished--");
    }
}
