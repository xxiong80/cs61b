import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    OffByN offBy5 = new OffByN(5);

    // Your tests go here.
    @Test
    public void testequalChars() {
        assertTrue(offBy5.equalChars('a','f'));
        assertTrue(offBy5.equalChars('f','a'));
        assertFalse(offBy5.equalChars('f','h'));
    }
}

