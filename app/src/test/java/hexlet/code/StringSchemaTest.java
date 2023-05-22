package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSchemaTest {
    private Validator v = new Validator();
    private StringSchema schema = v.string();

    @Test
    public void testStringValid1() {
        var actual = schema.isValid("");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringfinaValid2() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringRequired1() {
        var actual = schema.required().isValid("");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringRequired2() {
        var actual = schema.required().isValid(5);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringMinLength1() {
        var actual = schema.required().minLength(4).isValid("Hexlet");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringMinLrngth2() {
        var actual = schema.required().minLength(6).isValid("Hi");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringContains1() {
        var actual = schema.contains("Hex").isValid("Hexlet");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringContains2() {
        var actual = schema.contains("what").isValid("Hello, World!");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringAll1() {
        var actual = schema.required().minLength(4).contains("My").isValid("My world");
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStringAll2() {
        var actual = schema.required().minLength(4).contains("My").isValid("My");
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
