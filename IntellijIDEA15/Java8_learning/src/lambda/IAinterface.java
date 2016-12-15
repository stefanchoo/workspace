package lambda;

/**
 * Created by stefan on 2016/1/15.
 * 函数式抽象接口
 */
@FunctionalInterface    // 编译时检查，判断是否为函数式接口
public interface IAinterface {
    String funcA(String oneArgu);
}
