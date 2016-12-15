package com.africa.study.comparator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhusheng
 * @date 2016/11/28
 */
public class Main {
    public static void main(String[] args) {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("1", 10021));
        commands.add(new Command("2", 10027));
        commands.add(new Command("3", 10023));
        commands.add(new Command("4", 10028));
        commands.add(new Command("5", 10025));
        commands.add(new Command("8", 10022));

        commands.sort((c1, c2) ->
                c1.getSequenceNum() < c2.getSequenceNum() ? -1 : 1);

        commands.forEach(System.out::println);
    }
}
