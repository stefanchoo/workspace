package com.africa.study.annotation;

/**
 * @author zhuhusheng
 * @date 2016/6/8
 */
public class Dog {

    @AnimalName("旺财")
    private String name;

    @AnimalColor(animalColor = AnimalColor.Color.Green)
    private String color;

    @Zoo(id = 1, name = "老村长动物园", address = "花果山水帘洞府")
    private String zoo;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZoo() {
        return zoo;
    }

    public void setZoo(String zoo) {
        this.zoo = zoo;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", zoo='" + zoo + '\'' +
                '}';
    }
}
