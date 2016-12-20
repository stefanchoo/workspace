package com.africa.study.Java8.Annotations;

import lombok.Data;

/**
 * @author zhuhusheng
 * @date 2016/12/20
 */
// @Hints({@Hint("hint1"), @Hint("hint2")})   // old
@Hint("hint1")                                // new
@Hint("hint2")
@Data
public class Person {
    private String firstName;
    private String lastName;
}
