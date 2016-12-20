package com.africa.study.Java8.lambda;

/**
 * @author zhuhusheng
 * @date 2016/12/16
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("1234");
        System.out.println(converted1);

        Something something = new Something();
        Converter<String, String> converter2 = something::startWith;   // 方法引用
        String converted2 = converter2.convert("Java");
        System.out.println(converted2);

//        PersonFactory<Person> personFactory = new PersonFactory<Person>() {
//
//            @Override
//            public Person create(String firstName, String lastName) {
//                return new Person(firstName, lastName);
//            }
//        };
//        PersonFactory<Person> personFactory = (firstName, lastName) -> new Person(firstName, lastName);
//        PersonFactory<Person> personFactory = Person::new;


        PersonFactory<Person> personFactory = Person::new;        // 构造函数引用
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }

    public static final class Something {
        String startWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    public static final class Person {
        String firstName;
        String lastName;

        Person() {}

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString(){
            return  "Person {\r\n" +
                    ("firstName = " + firstName + "\r\n") +
                    "lastName = " + lastName + "\r\n"
                    +"}";
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

}
