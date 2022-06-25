package pro.sky.homework.HomeWorkCalculator;

import org.springframework.stereotype.Service;
@Service
public class CalculateService {
    public String Greeting(){
        return "<h1>Welcome to calculator!</h1>";
    }
    public Integer Addition (Integer num1, Integer num2){
        return  num1 + num2;
    }
    public Integer Subtraction (Integer num1, Integer num2) {
        return  num1 - num2;
    }
    public Integer Multiply(Integer num1, Integer num2){
        return num1 * num2;
    }
    public Number Division(Integer num1, Integer num2){
        return (double) num1 / num2;
    }
}

