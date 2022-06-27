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
    public String plus(@RequestParam(value="num1", required = false) Integer num1,
                       @RequestParam(value="num2", required = false) Integer num2){
        if (checkParameters(num1, num2)) {return "Result of calculation is " + num1 + " * " + num2 + " = "
                + calculateService.Addition(num1, num2);}
        else {return "Both parameters required!";}
    }
    @GetMapping(path ="/minus")
    public String minus(@RequestParam(value="num1", required = false) Integer num1,
                        @RequestParam(value="num2", required = false) Integer num2) {
        if (checkParameters(num1, num2)) {return "Result of calculation is " + num1 + " - " + num2 + " = "
                + calculateService.Subtraction(num1, num2);}
        else {return "Both parameters required!";}
    }
    @GetMapping(path ="/multiply")
    public String multiply(@RequestParam(value="num1", required = false) Integer num1,
                           @RequestParam(value="num2", required = false) Integer num2) {
        if (checkParameters(num1, num2)) {return "Result of calculation is " + num1 + " * " + num2 + " = "
                + calculateService.Multiply(num1, num2);}
        else {return "Both parameters required!";}
    }
    @GetMapping(path ="/divide")
    public String divide(@RequestParam(value="num1", required = false) Integer num1,
                         @RequestParam(value="num2", required = false) Integer num2) {
        if (num2 != null && num2 == 0){
            return "DIVISION ON ZERO!";
        }
        if (checkParameters(num1, num2)) {return "Result of calculation is " + num1 + " : " + num2 + " = "
                + calculateService.Division(num1, num2);}
        else {return "Both parameters required!";}
    }
    public boolean checkParameters(Integer a, Integer b){
     return (!Objects.isNull(a)&&!Objects.isNull(b));
    }
}
