package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    private Validator v = new Validator();
    private StringSchema schema = v.string();

    @Test
    public void testString1() {
        var expected = true;
        var actual = schema.isValid("");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString2() {
        var expected = true;
        var actual = schema.isValid(null);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString3() {
        schema.required();
        var actual = schema.isValid("");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString4() {
        schema.required();
        var actual = schema.isValid(5);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString5() {
        schema.required();
        schema.minLength(4);
        var actual = schema.isValid("Hexlet");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString6() {
        schema.required();
        schema.minLength(6);
        var actual = schema.isValid("Hi");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString7() {
        schema.contains("Hex");
        var actual = schema.isValid("Hexlet");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString8() {
        schema.contains("what");
        var actual = schema.isValid("Hello, World!");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
