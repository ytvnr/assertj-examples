package b_morecomplex;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class AssertJOtherAssertionsTest {


    @Test
    void assumptions() {
        Assumptions.assumeThat(1).isGreaterThan(2);
        Assertions.assertThat("The Lord of the Rings").isEqualTo("Star wars");
    }

    // TODO montrer des cas avec des objets imbriqués pour avoir des extractings, du containing exactly in order or not, etc etc
}
