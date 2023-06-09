package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public final NumberSchema required() {
        Predicate<Integer> req = Objects::nonNull;
        addValidation("required", req);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> posit = (i) -> Integer.class.isInstance(i)
                && ((int) i > 0)
                || i == null;
        addValidation("positive", posit);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        this.positive();
        Predicate<Integer> range = (i) -> Objects.nonNull(i)
                && start <= i
                && i <= end;
        addValidation("range", range);
        return this;
    }
}
