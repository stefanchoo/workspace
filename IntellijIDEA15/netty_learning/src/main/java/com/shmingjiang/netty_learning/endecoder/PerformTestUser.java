package com.shmingjiang.netty_learning.endecoder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by stefan on 2016/1/8.
 * jdk 序列化的性能比二进制码差许多
 */
public class PerformTestUser {
    public static void main(String[] args) throws Exception {
        User u = new User(10, "Welcome to Netty");
        int loop = 1000000;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(u);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("The jdk serializable cost time is : " + (endTime - startTime) + " ms");
        System.out.println("-------------------------------------------");

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = u.codeC(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The byte array serializable cost time is : " + (endTime - startTime) + " ms");
    }

}
