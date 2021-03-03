import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    @Disabled("Just testing a test")
    //@DisplayName("You can add a descriptive name for the test")
    void testAssert() {
        Assertions.assertEquals(1, 1);
    }
}
