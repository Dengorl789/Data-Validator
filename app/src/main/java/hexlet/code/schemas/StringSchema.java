package hexlet.code.schemas;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema{
    private boolean state = true;
    public void required() {
        Predicate<String> req = (s) -> Objects.nonNull(s)
                && !"".equals(s)
                && String.class.isInstance(s);
        limitations.put("required", req);
    }
    public void minLength(int minLength) {
        this.required();
        Predicate<String> min = (s) -> s.length() >= minLength;
        limitations.put("minLength", min);
    }
    public void contains(String pattern) {
        this.required();
        Predicate<String> cont = (s) -> s.contains(pattern);
        limitations.put("contains", cont);
    }

}

