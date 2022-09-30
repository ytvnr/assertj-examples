package a_simple;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class JUnit4SimpleAssertionsTest {

    @Test
    public void assert_on_simple_string() {
        Assert.assertNotNull("The Lord of the Rings");
        Assert.assertTrue("The Lord of the Rings".startsWith("The"));
        Assert.assertTrue("The Lord of the Rings".contains("Lord"));
        Assert.assertTrue("The Lord of the Rings".endsWith("Rings"));
        Assert.assertEquals("Frodo", "Frodo");
    }

    @Test
    public void assert_on_strings_array() {
        Assert.assertArrayEquals(new String[]{"Frodo", "Sam"}, new String[]{"Frodo", "Sam"});

        // 😢 Unfortunately, no assertArrayNotEquals method
    }

    // Will fail and its wanted
    @Test
    public void assertion_description() {
        Assert.assertFalse("The boolean should be false", true);
    }

    @Test(expected = NumberFormatException.class)
    public void assert_exception() {
        Integer.parseInt("A_string_that_should_cause_NumberFormatException");
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void assert_exception_access_object() {
        exceptionRule.expect(NumberFormatException.class);
        // ⚠️ expectMessage is a bad naming, it should be called expectMessageContaining
        exceptionRule.expectMessage("For input string");

        // ✅ The real assertion should be:
        exceptionRule.expectMessage("For input string: \"A_string_that_should_cause_NumberFormatException\"");

        Integer.parseInt("A_string_that_should_cause_NumberFormatException");
    }
}
