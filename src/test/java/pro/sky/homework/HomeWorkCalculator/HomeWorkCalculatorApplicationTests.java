package pro.sky.homework.HomeWorkCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeWorkCalculatorApplicationTests {
	private final CalculateService out = new CalculateService();
	private final Integer POSITIVE_VALUE = 5;
	private final Integer NEGATIVE_VALUE = -5;
	private final Integer ZERO = 0;
	String message = "Both parameters required!";

	@Test
	public void additionTest() {
		String result = out.Addition(NEGATIVE_VALUE, null);
		Assertions.assertEquals(message, result);
		result = out.Addition(null, ZERO);
		Assertions.assertEquals(message, result);
	}
	@Test
	public void subtractionTest(){
		String result = out.Subtraction(POSITIVE_VALUE, null);
		Assertions.assertEquals(message, result);
		result = out.Subtraction(ZERO, null);
		Assertions.assertEquals(message, result);
	}
	@Test
	public void multiplicationTest(){
		String result = out.Multiply(NEGATIVE_VALUE, null);
		Assertions.assertEquals(message, result);
		result = out.Multiply(null, ZERO);
		Assertions.assertEquals(message, result);
	}
	@Test
	public void divisionTest(){
		String result = out.Division(POSITIVE_VALUE, null);
		Assertions.assertEquals(message, result);
		Assertions.assertThrows(RuntimeException.class,()-> out.Division(NEGATIVE_VALUE,ZERO));
		Assertions.assertThrows(RuntimeException.class,()-> out.Division(null,ZERO));
	}
}
