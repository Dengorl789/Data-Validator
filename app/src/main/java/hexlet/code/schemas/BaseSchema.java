package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private Map<String, Predicate> validations = new HashMap<>();

    public final boolean isValid(Object objectForValidation) {
        boolean result;
        for (Map.Entry<String, Predicate> predicateEntry: validations.entrySet()) {
            result = predicateEntry.getValue().test(objectForValidation);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public final void addLimitation(String name, Predicate predicate) {
        this.validations.put(name, predicate);
    }
}
