package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    private Validator v = new Validator();
    private NumberSchema schema = v.number();
    @Test
    public void numberTest1() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest2() {
        var actual = schema.positive().isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest3() {
        var actual = schema.positive().isValid(-3);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest4() {
        var actual = schema.positive().isValid(3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest5() {
        var actual = schema.positive().isValid("3");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest6() {
        var actual = schema.positive().isValid(0);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest7() {
        var actual = schema.positive().range(3, 8).isValid(3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest8() {
        var actual = schema.positive().range(3, 8).isValid(2);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest9() {
        var actual = schema.positive().range(3, 8).isValid(6);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void numberTest10() {
        var actual = schema.positive().range(3, 8).isValid(null);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
