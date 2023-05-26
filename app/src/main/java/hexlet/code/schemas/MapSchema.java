package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        Predicate<Object> req = (m) -> Map.class.isInstance(m)
                                    && Objects.nonNull(m);
        addValidation("required", req);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map> sizeof = map -> map.size() == size;
        addValidation("sizeOf", sizeof);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> shape = value -> {
            return schemas.entrySet().stream().allMatch(e -> {
                Object v = ((Map) value).get(e.getKey());
                return e.getValue().isValid(v);
            });
        };
        addValidation("shape", shape);
        return this;
    }
}
