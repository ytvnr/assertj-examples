package b_morecomplex;

import io.ytvnr.Person;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.samePropertyValuesAs;

class Junit5OtherAssertionsTest {

    @Test
    void assumptions() {
        Assumptions.assumeTrue(1 == 2);
        Assertions.assertEquals("The Lord of the Rings", "Star wars");
    }

    // 😢This test required getters on Person object and a new dependency: org.harmcrest:hamcrest-all
    @Test
    public void recursive_equality() {
        Person sherlock = Person.buildSherlock();
        Person sherlock2 = Person.buildSherlock();

        Assertions.assertNotSame(sherlock, sherlock2);
        // Fail here and it's normal
//        Assertions.assertEquals(sherlock, sherlock2);

        // 😭 Junit 5 loses assertThat method, we have to use the Hamcrest one.
        MatcherAssert.assertThat(sherlock,
                samePropertyValuesAs(sherlock2));

        // 💥 No simple way of comparing objects excluding some fields
    }

    @Test
    void extracting_field() {
        Person person1 = Person.builder().name("Stephen").height(1.70).build();
        Person person2 = Person.builder().name("Mary").height(1.60).build();
        Person person3 = Person.builder().name("Thomas").height(1.76).build();
        Person person4 = Person.builder().name("Mary").height(1.71).build();

        List<Person> persons = List.of(person1, person2, person3, person4);

        Assertions.assertIterableEquals(persons.stream().map(Person::getName).toList(),
                List.of("Stephen", "Mary", "Thomas", "Mary"));

    }
}
