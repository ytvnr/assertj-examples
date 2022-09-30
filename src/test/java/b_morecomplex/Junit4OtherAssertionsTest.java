package b_morecomplex;

import io.ytvnr.Person;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@RunWith(BlockJUnit4ClassRunner.class)
public class Junit4OtherAssertionsTest {

    @Test
    public void assumptions() {
        Assume.assumeThat(1, is(2));
        Assert.assertEquals("The Lord of the Rings", "Star wars");
    }

    // 😢This test required getters on Person object and a new dependency: org.harmcrest:hamcrest-all
    @Test
    public void recursive_equality() {
        Person sherlock = Person.buildSherlock();
        Person sherlock2 = Person.buildSherlock();

        Assert.assertNotSame(sherlock, sherlock2);
        // Fail here and it's normal
        Assert.assertEquals(sherlock, sherlock2);

        Assert.assertThat(sherlock,
                samePropertyValuesAs(sherlock2));

        sherlock2.setHeight(1.70);

        // 💥 No simple way of comparing objects excluding some fields
    }

    @Test
    public void extracting_field() {
        Person person1 = Person.builder().name("Stephen").height(1.70).build();
        Person person2 = Person.builder().name("Mary").height(1.60).build();
        Person person3 = Person.builder().name("Thomas").height(1.76).build();
        Person person4 = Person.builder().name("Mary").height(1.71).build();

        List<Person> persons = List.of(person1, person2, person3, person4);

        Assert.assertThat(persons.stream().map(Person::getName).toList(),
                contains("Stephen", "Mary", "Thomas", "Mary"));

    }
}
