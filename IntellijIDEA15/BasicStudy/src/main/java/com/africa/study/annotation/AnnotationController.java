package com.africa.study.annotation;

import java.lang.reflect.Field;

/**
 * @author zhuhusheng
 * @date 2016/6/8
 */
public class AnnotationController {
    public static void getAnimalInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields) {
            if(field.isAnnotationPresent(AnimalName.class)) {
                AnimalName animalName = field.getAnnotation(AnimalName.class);
                System.out.println("名称：" + animalName.value());
            }else if (field.isAnnotationPresent(AnimalColor.class)) {
                AnimalColor animalColor = field.getAnnotation(AnimalColor.class);
                System.out.println("颜色：" + animalColor.animalColor());
            }else if(field.isAnnotationPresent(Zoo.class)) {
                Zoo zoo = field.getAnnotation(Zoo.class);
                System.out.println("动物园：{id=" + zoo.id() + ", name=" + zoo.name() + ", address=" + zoo.address() + "}");
            }
        }
    }
}
