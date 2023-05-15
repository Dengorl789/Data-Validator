package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSchemaTest {
    private Validator v = new Validator();
    private MapSchema schema = v.map();

    @Test
    public void mapTest1() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest2() {
        schema.required();
        var actual = schema.isValid(null);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest3() {
        schema.required();
        var actual = schema.isValid(new HashMap());
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest4() {
        schema.required();
        Map<String, String> data = Map.of("key1", "value1");
        var actual = schema.isValid(data);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest5() {
        schema.required();
        schema.sizeOf(2);
        Map<String, String> data = Map.of("key1", "value1");
        var actual = schema.isValid(data);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest6() {
        schema.required();
        schema.sizeOf(2);
        Map<String, String> data = Map.of("key1", "value1",
                                        "key2", "value2");
        var actual = schema.isValid(data);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest7() {
        schema.required();
        List<String> data1 = List.of("value1", "value2");
        var actual = schema.isValid(data1);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }

}
