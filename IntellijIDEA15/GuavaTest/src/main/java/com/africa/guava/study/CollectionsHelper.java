package com.africa.guava.study;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;


/**
 * @author zhuhusheng
 * @date 2016/6/2
 */
public class CollectionsHelper {

    public static ImmutableList listOf(Object element) {
        return ImmutableList.of(element);
    }

    public static ImmutableList listOf(Object e1, Object e2) {
        return ImmutableList.of(e1, e2);
    }

    public static ImmutableList listOf(Object e1, Object e2, Object e3) {
        return ImmutableList.of(e1, e2, e3);
    }

    public static ImmutableList listOf(Object e1, Object e2, Object e3, Object e4) {
        return ImmutableList.of(e1, e2, e3, e4);
    }

    public static ImmutableList listOf(Object e1, Object e2, Object e3, Object e4, Object e5) {
        return ImmutableList.of(e1, e2, e3, e4, e5);
    }

    public static ImmutableList listOf(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6) {
        return ImmutableList.of(e1, e2, e3, e4, e5, e6);
    }

    public static ImmutableList listOf(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7) {
        return ImmutableList.of(e1, e2, e3, e4, e5, e6, e7);
    }

    public static ImmutableList listOf(Object e1, Object e2, Object e3, Object e4, Object e5, Object e6, Object e7, Object e8) {
        return ImmutableList.of(e1, e2, e3, e4, e5, e6, e7, e8);
    }

    public static ImmutableMap mapOf(Object k1, Object v1) {
        return ImmutableMap.of(k1, v1);
    }

    public static ImmutableMap mapOf(Object k1, Object v1, Object k2, Object v2) {
        return ImmutableMap.of(k1, v1, k2, v2);
    }

    public static ImmutableMap mapOf(Object k1, Object v1, Object k2, Object v2, Object k3, Object v3) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3);
    }

    public static ImmutableMap mapOf(Object k1, Object v1, Object k2, Object v2, Object k3, Object v3, Object k4, Object v4) {
        return ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }
}
