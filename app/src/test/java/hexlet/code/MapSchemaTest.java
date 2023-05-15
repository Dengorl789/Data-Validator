package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSchemaTest {
    private Validator v = new Validator();
    private MapSchema schema = v.map();
    Map<String, BaseSchema> schemas = Map.of(
            "name", v.string().required(),
            "age", v.number().positive());

    @Test
    public void mapTest1() {
        var actual = schema.isValid(null);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest2() {
        var actual = schema.required().isValid(null);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest3() {
        var actual = schema.required().isValid(new HashMap());
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest4() {
        Map<String, String> data = Map.of("key1", "value1");
        var actual = schema.required().isValid(data);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest5() {
        Map<String, String> data = Map.of("key1", "value1");
        var actual = schema.required().sizeOf(2).isValid(data);
        var expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest6() {
        Map<String, String> data = Map.of("key1", "value1",
                                        "key2", "value2");
        var actual = schema.required().sizeOf(2).isValid(data);
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

    @Test
    public void mapTest8() {
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        var actual = schema.shape(schemas).isValid(human1);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest9() {
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        var actual = schema.shape(schemas).isValid(human2);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest10() {
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        var actual = schema.shape(schemas).isValid(human3);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapTest11() {
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        var actual = schema.shape(schemas).isValid(human4);
        var expected = true;
        Assertions.assertEquals(expected, actual);
    }
}
