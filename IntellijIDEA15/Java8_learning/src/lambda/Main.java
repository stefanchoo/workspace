package lambda;

/**
 * Created by stefan on 2016/1/15.
 *
 * 1. 无参 （）-> { }
 * 2. 一个参数
 * a.（String s） -> { } ;
 * b. (s) -> { };
 * c.s -> { }
 *
 * 3. 有返回值的时候
 *
 * ！！匿名内部类中无法调用外部非final对象
 * lambda表达式可以，但是进入lambda表达式之后就成为了一个final对象，无法再改变！！
 */
public class Main {
    public static void main(String[] args) {
        int a = 1;

        Runnable noArgument = () -> {
            System.out.println("空参数的lambda表达式");
//            a += 1;                 // 这里就会报错
        };

        new Thread(noArgument).start();

        System.out.println("一个参数的lambda表达式");
        Main.funcA(
                (String s) -> {
                    return s;
                }
        );
    }

    public static String funcA(IAinterface ia) {
        return ia.funcA("一个参数的lambda表达式");
    }
}
