package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> req = (m) -> Map.class.isInstance(m)
                                    && Objects.nonNull(m);
        limitations.put("required", req);
        return this;
    }
    public MapSchema sizeOf(int size) {
        Predicate<Map> sizeof = map -> map.size() >= size;
        limitations.put("sizeOf", sizeof);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> schemaEntry: schemas.entrySet()) {

        }
        return this;
    }
}
