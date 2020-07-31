import org.junit.Test;
import static org.junit.Assert.*;

public class testFlik {
    @Test
    public void testIsSame() {
        Integer a = 127;
        Integer b = 127;
        assertTrue(Flik.isSameNumber(a, b));
    }

}
