package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
	Validator v = new Validator();
	StringSchema schema = v.string();

	@Test
	public void testString1() {
		var expected = true;
		var actual = schema.isValid("");
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void testString2() {
		var expected = true;
		var actual = schema.isValid(null);
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void testString3() {
		schema.required();
		var actual = schema.isValid("");
		var expected = false;
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void testString4() {
		schema.required();
		var actual = schema.isValid(null);
		var expected = false;
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void testString5() {
		schema.required();
		var actual = schema.isValid("Hexlet");
		var expected = true;
		Assertions.assertEquals(expected, actual);
	}
	@Test void testString6() {
		var actual = schema.contains("hex");
		var expected = true;
		Assertions.assertEquals(expected, actual);
	}
}
