package com.africa.study.annotation;

/**
 * @author zhuhusheng
 * @date 2016/12/21
 */
public class Overview {
    /** Java 注解介绍  @interface
     ** Java注解是附加在代码中的一些元信息，用于编译和运行时进行解析和使用，起到说明、配置的功能.
     ** 定义一个方法即为注解类型定义了一个元素，方法的声明不允许有参数或throw语句，返回值类型被限定
     ** 为原始数据类型、字符串String、Class、enums、注解类型，或前面这些的数组，方法可以有默认值
     ** 注解可以从源文件，class文件或者在运行时通过反射机制多种方式读取
     **/

    /** Java 元注解
     *  @Target          定义注解的作用目标 TYPE FILED METHOD PARAMETER CONSTRUCT LOCAL_VARIABLE ANNOTATION_TYPE PACKAGE
     *  @Retention       定义注解的保留策略 Source:源码中 Class:字节码中存在，运行时获取不到 Runtime：运行时可以通过反射获取到
     *  @Document        该注解会被包含在javadoc中
     *  @Inherited       子类可以继承父类
     */
}
