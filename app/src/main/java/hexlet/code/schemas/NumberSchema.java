package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public void positive() {
        Predicate<Object> posit = (i) -> Integer.class.isInstance(i)
                && ((int) i > 0)
                || i == null;
        limitations.put("positive", posit);
    }

    public void range(int start, int end) {
        this.positive();
        Predicate<Integer> range = (i) -> Objects.nonNull(i)
                && start <= i
                && i <= end;
        limitations.put("range", range);
    }
}
