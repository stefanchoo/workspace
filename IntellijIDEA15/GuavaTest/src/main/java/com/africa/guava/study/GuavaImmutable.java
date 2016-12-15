package com.africa.guava.study;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;

import java.util.Set;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaImmutable {
    public static void main(String[] args) {
        Set<String> immutableNamedColors =
                /*ImmutableSet.<String>builder()
                .add("red", "green","black","white","grey")
                .build()*/
                ImmutableSet.of("red", "green","black","white","grey")
                /*ImmutableSet.copyOf(new String[]{"red", "green","black","white","grey"})*/
                ;
        immutableNamedColors.forEach(i -> System.out.println(i));

        Multiset multiset = HashMultiset.create();
        String sentences = "this is a story, there is a good girl in the story";
        Iterable<String> words = Splitter.onPattern("[^a-z]{1,}")
                .omitEmptyStrings()
                .trimResults()
                .split(sentences);
        words.forEach(w -> multiset.add(w));
        multiset.forEach(m -> System.out.println(
                m + ":" + multiset.count(m)
        ));
    }
}
