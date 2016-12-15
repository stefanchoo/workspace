package String2Float;

import org.junit.Test;

/**
 * TestString2Float
 * desc
 * Created by stefan on 2016/3/10.
 */
public class TestString2Float {
    @Test
    public void string2float() {
        String a = "3.145667";
        Float b = Float.valueOf(a);
        System.out.println("Float [ b = " + b + " ]" );
    }
}
