package b_morecomplex;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(BlockJUnit4ClassRunner.class)
public class Junit4OtherAssertionsTest {

    @Test
    public void assumptions() {
        Assume.assumeThat(1, is(2));
        Assert.assertEquals("The Lord of the Rings", "Star wars");
    }
}
