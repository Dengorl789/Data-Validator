package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        Predicate<Object> req = (m) -> Map.class.isInstance(m)
                                    && Objects.nonNull(m);
        addLimitation("required", req);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map> sizeof = map -> map.size() == size;
        addLimitation("sizeOf", sizeof);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> shape = value -> {
            return schemas.entrySet().stream().allMatch(e -> {
                Object v = ((Map) value).get(e.getKey());
                return e.getValue().isValid(v);
            });
        };
        addLimitation("shape", shape);
        return this;
    }
}
