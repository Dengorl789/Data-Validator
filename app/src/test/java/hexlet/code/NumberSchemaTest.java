package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSchemaTest {
    Validator v = new Validator();
    NumberSchema schema = v.number();
    @Test
    public void numberTest1() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest2() {
        schema.positive();
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest3() {
        schema.positive();
        var actual = schema.isValid(-3);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest4() {
        schema.positive();
        var actual = schema.isValid(3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest5() {
        schema.positive();
        var actual = schema.isValid("3");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest6() {
        schema.positive();
        var actual = schema.isValid(0);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest7() {
        schema.positive();
        schema.range(3, 8);
        var actual = schema.isValid(3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest8() {
        schema.positive();
        schema.range(3, 8);
        var actual = schema.isValid(2);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void numberTest9() {
        schema.positive();
        schema.range(3, 8);
        var actual = schema.isValid(6);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
}
