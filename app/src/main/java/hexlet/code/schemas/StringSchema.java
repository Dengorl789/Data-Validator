package hexlet.code.schemas;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema {
    private Map<String, Predicate> limitations = new HashMap<>();
    private boolean state = true;
    public void required() {
        Predicate<String> req = (s) -> Objects.nonNull(s) && !s.equals("");
        limitations.put("required", req);
    }
    public void minLength(int minLength) {
        Predicate<String> min = (s) -> s.length() >= minLength;
        limitations.put("minLength", min);
    }
    public void contains(String pattern) {
        Predicate<String> cont = (s) -> s.contains(pattern);
        limitations.put("contains", cont);
    }
    public boolean isValid(Object validatedObject) {
        if (Objects.nonNull(validatedObject)
                && validatedObject.getClass() != String.class) {
            return false;
        }
        boolean result = true;
        for (Map.Entry<String, Predicate> predicate : limitations.entrySet()) {
            result = predicate.getValue().test(validatedObject);
        }
        return result;
    }
}

