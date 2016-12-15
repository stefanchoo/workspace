package com.africa.guava.study;

import com.google.common.base.Objects;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaObjects {
    public static void main(String[] args) {
        Object a = null;
        Object b = new Object();
        boolean aEqualsB = Objects.equal(a, b);    // equal 方法中更避免了 null
        System.out.println("aEqualsB = " + aEqualsB);
        Student stefan = new Student();
        stefan.setId(1);
        stefan.setName("StefanChoo");
        stefan.setAge(24);
        System.out.println(stefan);
    }

    public static class Student {
        private int id;
        private String name;
        private int age;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            return Objects.toStringHelper(this)
                    .add("id", id)
                    .add("name", name)
                    .add("age", age)
                    .toString();
        }
    }
}

