package a_simple;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JUnit5SimpleAssertionsTest {

    @Test
    void assert_on_simple_string() {
        Assertions.assertNotNull("The Lord of the Rings");
        Assertions.assertTrue("The Lord of the Rings".startsWith("The"));
        Assertions.assertTrue("The Lord of the Rings".contains("Lord"));
        Assertions.assertTrue("The Lord of the Rings".endsWith("Rings"));
        Assertions.assertEquals("Frodo", "Frodo");
    }

    @Test
    void assert_on_strings_array() {
        Assertions.assertArrayEquals(new String[]{"Frodo", "Sam"}, new String[]{"Frodo", "Sam"});

        // 😢 Unfortunately, still no assertArrayNotEquals method
    }

    // Will fail and its wanted
    @Test
    void assertion_description() {
        Assertions.assertFalse(true, "The boolean should be false");
    }

    @Test
    void assert_exception() {
        final NumberFormatException exception = Assertions.assertThrows(NumberFormatException.class, () ->
                Integer.parseInt("A_string_that_should_cause_NumberFormatException")
        );

        Assertions.assertEquals("For input string: \"A_string_that_should_cause_NumberFormatException\"", exception.getMessage());
    }
}
