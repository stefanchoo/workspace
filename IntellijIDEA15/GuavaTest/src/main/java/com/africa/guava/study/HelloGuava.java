package com.africa.guava.study;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.africa.guava.study.CollectionsHelper.listOf;
import static com.africa.guava.study.CollectionsHelper.mapOf;

/**
 * Guava 001 : Elegant
 *
 * @author zhuhusheng
 * @date 2016/6/2
 */
public class HelloGuava {
    public static void main(String[] args) {
        // too ugly
        Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long, List<String>>>();

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Set<String> set = new HashSet<String>();

        // how about this ? static import
        Map<String, Map<Long, List<String>>> gMap = newHashMap();
        List<String> gList = newArrayList();
        Set<String> gSet = newHashSet();

        // this looks nice
        ImmutableList<String> igList = listOf("a", "b", "c", "d");
        ImmutableMap<String, String> igMap = mapOf("key1", "value1", "key2", "value2");

        igList.forEach(i -> System.err.println(i));

        igMap.forEach((k, v) -> System.err.println(k + "=>" + v));

        File file = new File(HelloGuava.class.getResource("/test.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(l -> System.err.println(l));
    }
}
