package com.shmingjiang.netty_learning.endecoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by stefan on 2016/1/8.
 * jdk序列化的码流大小差不多是二进制码的5倍
 */
public class TestUser {

    public static void main(String[] args) throws IOException {
        User u = new User(100, "Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(u);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is : " + b.length);
        bos.close();
        System.out.println("--------------------------------");
        System.out.println("The byte array serializable length is : " + u.codeC().length );
    }
}
