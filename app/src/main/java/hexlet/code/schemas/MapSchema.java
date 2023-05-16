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
    public MapSchema sizeof(int size) {
        Predicate<Map> sizeof = map -> map.size() >= size;
        limitations.put("sizeOf", sizeof);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> shape = value -> {
            return schemas.entrySet().stream().allMatch(e -> {
                Object v = ((Map) value).get(e.getKey());
                return e.getValue().isValid(v);
            });
        };
        limitations.put("shape", shape);
        return this;
    }
}
