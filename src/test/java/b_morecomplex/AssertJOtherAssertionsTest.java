package b_morecomplex;


import io.ytvnr.Person;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.assertj.core.api.HamcrestCondition;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class AssertJOtherAssertionsTest {


    @Test
    void assumptions() {
        Assumptions.assumeThat(1).isGreaterThan(2);
        Assertions.assertThat("The Lord of the Rings").isEqualTo("Star wars");
    }

    @Test
    void recursive_equality() {
        Person sherlock = Person.buildSherlock();
        Person sherlock2 = Person.buildSherlock();

        Assertions.assertThat(sherlock).isNotSameAs(sherlock2);
        // Fail here and it's normal
//        Assertions.assertThat(sherlock).isEqualTo(sherlock2);

        Assertions.assertThat(sherlock)
                .usingRecursiveComparison()
                .isEqualTo(sherlock2);

        Assertions.assertThat(sherlock)
                .isEqualToComparingFieldByField(sherlock2);

        sherlock2.setHeight(1.70);

        Assertions.assertThat(sherlock)
                .isEqualToIgnoringGivenFields(sherlock2, "height");

        // 🤩 Assertj also allow to use Hamcrest
        Assertions.assertThat(sherlock.getName()).is(HamcrestCondition.matching(StringContains.containsString("lock")));
    }

    @Test
    void extracting_field() {
        Person person1 = Person.builder().name("Stephen").height(1.70).build();
        Person person2 = Person.builder().name("Mary").height(1.60).build();
        Person person3 = Person.builder().name("Thomas").height(1.76).build();
        Person person4 = Person.builder().name("Mary").height(1.71).build();

        List<Person> persons = List.of(person1, person2, person3, person4);

        Assertions.assertThat(persons)
                .extracting("name")
                .containsExactly("Stephen", "Mary", "Thomas", "Mary")
                .containsOnlyOnce("Stephen", "Thomas");

    }
}
