package com.africa.guava.study;

import com.google.common.io.Files;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import static com.google.common.base.Preconditions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static java.lang.System.*;


/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaFiles {

    static class CounterLine implements LineProcessor<Integer> {
        private int rowNum = 0;

        @Override
        public boolean processLine(String line) throws IOException {
            rowNum++;
            return true;
        }

        @Override
        public Integer getResult() {
            return rowNum;
        }
    }

    public static void main(String[] args) throws IOException {
        doFileWrite("test.txt", "abc\nbcd\nefg");
        doFileRead("test.txt", Charsets.UTF_8);
        doFileRead("test.txt", Charsets.UTF_8, new CounterLine());
    }

    /**
     * 向文件中写入字节流
     *
     * @param fileName 要写入文件的文件名
     * @param contents 要写入的文件内容
     */
    public static void doFileWrite(final String fileName, final String contents) {
        checkNotNull(fileName, "Provided file name for writing must NOT be null.");
        checkNotNull(contents, "Unable to write null contents.");
        final File newFile = new File(fileName);
        try {
            Files.write(contents.getBytes(), newFile);
        } catch (IOException fileIoEx) {
            err.println("ERROR trying to write to file '" + fileName + "' - "
                    + fileIoEx.toString());
        }
    }

    public static void doFileRead(final String fileName, Charset charset) throws IOException {
        checkNotNull(fileName, "Provided file name for writing must NOT be null.");
        checkNotNull(charset, "Provided charset must NOT be null");
        File testFile = new File(fileName);
        List<String> lines = Files.readLines(testFile, charset);
        lines.forEach(l -> System.out.println(l));
    }

    public static void doFileRead(final String fileName, Charset charset, CounterLine counterLine) throws IOException {
        File testFile = new File(fileName);
        Files.readLines(testFile, charset, counterLine);
        System.out.println(counterLine.getResult());
    }
}
