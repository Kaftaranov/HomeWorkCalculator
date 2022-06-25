package pro.sky.homework.HomeWorkCalculator;

import org.springframework.stereotype.Service;
@Service
public class CalculateService {
    public String Greeting(){
        return "<h1>Welcome to calculator!</h1>";
    }
    public int Addition (int num1, int num2){
        return  num1 + num2;
    }
    public int Subtraction (int num1, int num2) {
        return  num1 - num2;
    }
    public int Multiply(int num1, int num2){
        return num1 * num2;
    }
    public Number Division(int num1, int num2){
        return (double) num1 / num2;
    }
}

