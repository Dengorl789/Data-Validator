package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    private Validator v = new Validator();
    private StringSchema schema = v.string();

    @Test
    public void testString1() {
        var actual = schema.isValid("");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString2() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString3() {
        var actual = schema.required().isValid("");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString4() {
        var actual = schema.required().isValid(5);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString5() {
        var actual = schema.required().minLength(4).isValid("Hexlet");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString6() {
        var actual = schema.required().minLength(6).isValid("Hi");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString7() {
        var actual = schema.contains("Hex").isValid("Hexlet");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testString8() {
        var actual = schema.contains("what").isValid("Hello, World!");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
