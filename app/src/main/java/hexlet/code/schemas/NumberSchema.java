package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        Predicate<Integer> req = Objects::nonNull;
        limitations.put("required", req);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Object> posit = (i) -> Integer.class.isInstance(i)
                && ((int) i > 0)
                || i == null;
        limitations.put("positive", posit);
        return this;
    }

    public NumberSchema range(int start, int end) {
        this.positive();
        Predicate<Integer> range = (i) -> Objects.nonNull(i)
                && start <= i
                && i <= end;
        limitations.put("range", range);
        return this;
    }
}
