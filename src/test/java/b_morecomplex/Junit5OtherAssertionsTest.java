package b_morecomplex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class Junit5OtherAssertionsTest {

    @Test
    void assumptions() {
        Assumptions.assumeTrue(1 == 2);
        Assertions.assertEquals("The Lord of the Rings", "Star wars");
    }
}
