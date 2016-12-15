package com.africa.study.comparator;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhuhusheng
 * @date 2016/12/5
 */
public class ListComparator {

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2);
        List<Integer> list2 = Lists.newArrayList(1, 3);
        System.out.println(getChangeIndex(list1, list2));
    }

    /**
     * 比较数组变化量
     */
    public static int getChangeIndex(Object preValue, Object postValue) {
        List<Integer> preValues = (List<Integer>)preValue;
        List<Integer> postValues = (List<Integer>)postValue;
        for (int i = 0; i < preValues.size(); i++) {
            if(preValues.get(i).intValue() != postValues.get(i).intValue()) return i;
        }
        return -1;
    }
}
