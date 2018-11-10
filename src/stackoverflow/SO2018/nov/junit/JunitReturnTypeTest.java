package stackoverflow.SO2018.nov.junit;

import org.junit.Assert;
import org.junit.Test;

public class JunitReturnTypeTest {

    private static Object returnInt() {
        int a=5;
        return a;
    }

    @Test
    public void testInstance() {
        Assert.assertTrue(Integer.class.isInstance(returnInt()));
    }

    @Test()
    public void testClassCastException() {
        try {
            int a = (Integer) returnInt();
        } catch (ClassCastException e) {
            Assert.fail();
        }
    }
}
