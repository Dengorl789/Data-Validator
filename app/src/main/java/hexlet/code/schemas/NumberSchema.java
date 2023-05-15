package hexlet.code.schemas;


import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema{
    public void positive() {
        Predicate<Integer> posit = (i) -> (i > 0)
                && Integer.class.isInstance(i);
        limitations.put("positive", posit);
    }

    public void range(int start, int end) {
        this.positive();
        Predicate<Integer> range = (i) -> start <= i && i <= end;
        limitations.put("range", range);
    }
}
