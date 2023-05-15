package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public void required() {
        Predicate<Object> req = (m) -> Map.class.isInstance(m)
                                    && Objects.nonNull(m);
        limitations.put("required", req);
    }
    public void sizeOf(int size) {
        Predicate<Map> sizeof = map -> map.size() >= size;
        limitations.put("sizeOf", sizeof);
    }
}
