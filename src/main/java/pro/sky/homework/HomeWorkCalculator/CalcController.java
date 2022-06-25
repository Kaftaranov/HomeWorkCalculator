package pro.sky.homework.HomeWorkCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalculateService calculateService;
    public CalcController(CalculateService calculateService){
        this.calculateService = calculateService;
    }
    @GetMapping()
    public String Greeting() {
        return calculateService.Greeting();
    }

    @GetMapping(path ="/plus")
    public String plus(@RequestParam("num1") int num1,
                       @RequestParam("num2") int num2){
        return  checkParameters(num1, num2) + num1 + " + " + num2 + " = " + calculateService.Addition(num1, num2);
    }
    @GetMapping(path ="/minus")
    public String minus(@RequestParam(value="num1") int num1,
                        @RequestParam(value="num2") int num2) {
        return  checkParameters(num1, num2)+ num1 + " - " + num2 + " = " + calculateService.Subtraction(num1, num2);
    }
    @GetMapping(path ="/multiply")
    public String multiply(@RequestParam(value="num1") int num1,
                           @RequestParam(value="num2") int num2) {
        return checkParameters(num1, num2) + num1 + " * " + num2 + " = " + calculateService.Multiply(num1, num2);
    }
    @GetMapping(path ="/divide")
    public String divide(@RequestParam(value="num1") int num1,
                         @RequestParam(value="num2") int num2) {
        if (num2 == 0){
            return "DIVISION ON ZERO!";
        }
        return  checkParameters(num1, num2) + num1 + " : " + num2 + " = " + calculateService.Division(num1, num2);
    }
    public String checkParameters(int a, int b){
        if (Objects.isNull(a)||Objects.isNull(b)){
            return "Both parameters required!";}
        return "Result of calculation: ";
    }
}
