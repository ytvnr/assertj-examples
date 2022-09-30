package a_simple;


import asserts.PersonAssert;
import io.ytvnr.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class AssertJSimpleAssertionsTest {

    @Test
    void assert_on_simple_string() {
        Assertions.assertThat("The Lord of the Rings")
                .isNotNull()
                .isNotBlank()
                .startsWith("The")
                // if we don't care about the case, we simply ignore it during assertion
                .containsIgnoringCase("lord")
                .endsWith("Rings");

        Assertions.assertThat("Frodo".equalsIgnoreCase("frodo")).isTrue();
        Assertions.assertThat("Frodo").isEqualToIgnoringCase("FrOdo");
    }

    @Test
    void assert_on_strings_array() {
        Assertions.assertThat(new String[]{"Frodo", "Sam"})
                .isNotEmpty()
                .isEqualTo(new String[]{"Frodo", "Sam"})
                .isNotEqualTo(new String[]{"Frodo", "Sam", "Pippin", "Merry"});
    }

    // Will fail and its wanted
    @Test
    void assertion_description() {
        Assertions.assertThat(true)
                .withFailMessage("The boolean should be false and it is '%b'", true)
                .isFalse();
    }

    @Test
    void assert_exception() {

        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> Integer.parseInt("A_string_that_should_cause_NumberFormatException"))
                .withMessageStartingWith("For input string:")
                .withMessageEndingWith("\"A_string_that_should_cause_NumberFormatException\"");
    }

    @Test
    void assert_exception_bdd_style() {

        // Given
        String[] hobbits = {"Frodo", "Sam", "Pippin", "Merry"};

        // When accessing a hobbit not in the array
        Throwable thrown = Assertions.catchThrowable(() -> System.out.println(hobbits[10]));

        // Then
        Assertions.assertThat(thrown)
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("10");

        // Then (BDD Style with BDDAssertions)
        then(thrown)
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("10");
    }

    @Test
    void custom_assertion() {
        PersonAssert.assertThat(Person.buildSherlock())
                .hasName("Sherlock")
                .hasStreet("Baker Street");
    }
}
