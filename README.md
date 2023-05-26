### Hexlet tests and linter status:
[![Actions Status](https://github.com/Dengorl789/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/Dengorl789/java-project-78/actions)
<a href="https://codeclimate.com/github/Dengorl789/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/69c1884b9f918f62f9a8/maintainability" /></a>
<a href="https://codeclimate.com/github/Dengorl789/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/69c1884b9f918f62f9a8/test_coverage" /></a>

Help information

By cloning this repository you could add a validation library for such types of objects as Integer, String and Map.
Create sample object of a Validator class, then use methods string(), number() or map() to choose which type of objects you want to validate.
By adding validation checks, you can improve your validator, because all checks are saved during one session.
Also there is a scheme of a nested validation in MapSchema class, so you can validate map values with shape() method.
For example:

```Validator v = new Validator();
StringSchema schema = v.string();
schema.required().minLength(5).contains("World").isValid("Hello, World!"); //true
schema.isValid("What does the fox say?"); //false because the string has to contain substring "World" from previous check.

//or for nested validation

Validator v = new Validator();
MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> user1 = new HashMap<>();
human1.put("name", "Jack");
human1.put("age", 25);
schema.isValid(user1); // true

Map<String, Object> user2 = new HashMap<>();
human4.put("name", "Mary");
human4.put("age", -5);
schema.isValid(user2); // false```

