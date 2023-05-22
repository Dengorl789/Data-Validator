package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private Map<String, Predicate> limitations = new HashMap<>();

    public final boolean isValid(Object validatedObject) {
        boolean result;
        for (Map.Entry<String, Predicate> predicateEntry: limitations.entrySet()) {
            result = predicateEntry.getValue().test(validatedObject);
            if (!result) {
                return false;
            }
        }
        return true;
    }
    public final void addLimitation(String name, Predicate predicate) {
        this.limitations.put(name, predicate);
    }
}
