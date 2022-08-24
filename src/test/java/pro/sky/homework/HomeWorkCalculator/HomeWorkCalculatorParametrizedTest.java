package pro.sky.homework.HomeWorkCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HomeWorkCalculatorParametrizedTest {
    private final CalculateService out = new CalculateService();
    private static final Integer POSVAL = 5;
    private static final Integer NEGVAL = -5;
    private static final Integer ZERO = 0;
    private static final String message = "Both parameters required!";

    public static Stream<Arguments> parametersForTests(){
        return Stream.of(
                Arguments.of(NEGVAL,null, message ),
                Arguments.of(null, POSVAL,message)
        );
    }

    public static Stream<Arguments> specialParametersForDivision(){
        return Stream.of(
                Arguments.of(POSVAL, ZERO, RuntimeException.class),
                Arguments.of(null,ZERO, RuntimeException.class)
        );
    }
    @ParameterizedTest
    @MethodSource("parametersForTests")
    public void shouldGenerateCorrectMessage(Integer value1, Integer value2, String expectedmessage){
        String result = out.Addition(value1, value2);
        Assertions.assertEquals(expectedmessage, result);
        result = out.Subtraction(value1, value2);
        Assertions.assertEquals(expectedmessage, result);
        result = out.Multiply(value1, value2);
        Assertions.assertEquals(expectedmessage, result);
    }
    @ParameterizedTest
    @MethodSource("specialParametersForDivision")
    public void shouldThrowException(Integer value1, Integer zero){
        Assertions.assertThrows(RuntimeException.class,()-> out.Division(value1,zero));
        Assertions.assertThrows(RuntimeException.class,()-> out.Division(value1,zero));
    }

}