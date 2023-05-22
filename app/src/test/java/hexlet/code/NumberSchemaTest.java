package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    private Validator v = new Validator();
    private NumberSchema schema = v.number();
    @Test
    public void numberTestValid() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestRequired1() {
        var actual = schema.required().isValid(4);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestRequired2() {
        var actual = schema.required().isValid(null);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestPositive1() {
        var actual = schema.positive().isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestPositive2() {
        var actual = schema.positive().isValid(-3);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestPositive3() {
        var actual = schema.positive().isValid(3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestPositive4() {
        var actual = schema.positive().isValid("3");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestPositive5() {
        var actual = schema.positive().isValid(0);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestRange1() {
        var actual = schema.positive().range(3, 8).isValid(3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestRange2() {
        var actual = schema.positive().range(3, 8).isValid(2);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTestRange3() {
        var actual = schema.positive().range(3, 8).isValid(6);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void numberTestRange4() {
        var actual = schema.positive().range(3, 8).isValid(null);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
