package hexlet.code.schemas;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    public final StringSchema required() {
        Predicate<Object> req = (s) -> String.class.isInstance(s)
                && Objects.nonNull(s)
                && !"".equals(s);
        addValidation("required", req);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        this.required();
        Predicate<String> min = (s) -> s.length() >= minLength;
        addValidation("minLength", min);
        return this;
    }

    public final StringSchema contains(String pattern) {
        this.required();
        Predicate<String> cont = (s) -> s.contains(pattern);
        addValidation("contains", cont);
        return this;
    }
}

