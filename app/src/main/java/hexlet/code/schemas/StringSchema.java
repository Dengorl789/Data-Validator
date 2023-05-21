package hexlet.code.schemas;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    private boolean state = true;
    public final StringSchema required() {
        Predicate<Object> req = (s) -> String.class.isInstance(s)
                && Objects.nonNull(s)
                && !"".equals(s);
        addLimitation("required", req);
        return this;
    }
    public final StringSchema minLength(int minLength) {
        this.required();
        Predicate<String> min = (s) -> s.length() >= minLength;
        addLimitation("minLength", min);
        return this;
    }
    public final StringSchema contains(String pattern) {
        this.required();
        Predicate<String> cont = (s) -> s.contains(pattern);
        addLimitation("contains", cont);
        return this;
    }

}

