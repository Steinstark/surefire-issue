import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void shouldRun() {
        Assertions.assertTrue(true);
    }

    @Nested
    class NestedTests {

        @Test
        void shouldNotRun() {
            Assertions.assertFalse(true);
        }
    }
}
