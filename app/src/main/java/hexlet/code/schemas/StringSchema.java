package hexlet.code.schemas;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    private boolean state = true;
    public StringSchema required() {
        Predicate<Object> req = (s) -> String.class.isInstance(s)
                && Objects.nonNull(s)
                && !"".equals(s);
        limitations.put("required", req);
        return this;
    }
    public StringSchema minLength(int minLength) {
        this.required();
        Predicate<String> min = (s) -> s.length() >= minLength;
        limitations.put("minLength", min);
        return this;
    }
    public StringSchema contains(String pattern) {
        this.required();
        Predicate<String> cont = (s) -> s.contains(pattern);
        limitations.put("contains", cont);
        return this;
    }

}

