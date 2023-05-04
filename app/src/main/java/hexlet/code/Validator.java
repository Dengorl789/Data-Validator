package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Validator {
    private Validator v;
    public Validator() {

    }
    public StringSchema string() {
        return new StringSchema();
    }
}
