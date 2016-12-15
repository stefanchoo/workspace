package com.africa.study.comparator;

import lombok.Data;

/**
 * @author zhuhusheng
 * @date 2016/11/28
 */
@Data
public class Command {
    private String name;
    private Integer sequenceNum;

    public Command(String name, Integer sequenceNum) {
        this.name = name;
        this.sequenceNum = sequenceNum;
    }

    @Override
    public String toString() {
        return "Command{" +
                "name='" + name + '\'' +
                ", sequenceNum=" + sequenceNum +
                '}';
    }
}
