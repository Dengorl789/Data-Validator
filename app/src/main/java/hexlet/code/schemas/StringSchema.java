package hexlet.code.schemas;
import java.util.Objects;
public class StringSchema {
    private String str;
    private boolean state = true;
    public void required() {
        this.state = Objects.nonNull(this.str) && !this.str.equals("");
    }
    public void minLength(int minLength) {
        required();
        this.state = this.str.length() >= minLength;
    }
    public boolean contains(String pattern) {
        return this.state = this.str.contains(pattern);
    }
    public boolean  isValid(String vString) {
        this.str = vString;
        required();
        return state;
    }
    public boolean  isValid(int minLength) {
        required();
        return this.str.length() >= minLength;
    }
}
