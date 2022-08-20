package pro.sky.homework.HomeWorkCalculator;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CalculateService {
    public String Greeting(){
        return "<h1>Welcome to calculator!</h1>";
    }
    public String Addition (Integer num1, Integer num2){
        if (checkParameters(num1, num2)){
            return "Result of calculation is " + num1 + " + " + num2 + " = "+ (num1 + num2);
        }
        else {
           return "Both parameters required!";
        }
    }
    public String Subtraction (Integer num1, Integer num2) {
        if (checkParameters(num1, num2)) {
            return "Result of calculation is " + num1 + " - " + num2 + " = " + (num1 - num2);
        }else{
            return "Both parameters required!";
        }
    }
    public String Multiply(Integer num1, Integer num2){
        if (checkParameters(num1, num2)) {
            return "Result of calculation is " + num1 + " * " + num2 + " = " + (num1 * num2);
        }else{
            return "Both parameters required!";
        }
    }
    public String Division(Integer num1, Integer num2){
        if (num2 != null && num2 == 0){
            throw new IllegalArgumentException("DIVISION BY ZERO!");}
        if (checkParameters(num1, num2)) {
            return "Result of calculation is " + num1 + " : " + num2 + " = " + (num1 / num2);
        }else {
            return "Both parameters required!";
        }
    }
    public boolean checkParameters(Integer a, Integer b){
        return (!Objects.isNull(a)&&!Objects.isNull(b));
    }
}

