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
         return  calculateService.Addition(num1, num2);
    }
    @GetMapping(path ="/minus")
    public String minus(@RequestParam(value="num1", required = false) Integer num1,
                        @RequestParam(value="num2", required = false) Integer num2) {
        return  calculateService.Subtraction(num1, num2);
    }
    @GetMapping(path ="/multiply")
    public String multiply(@RequestParam(value="num1", required = false) Integer num1,
                           @RequestParam(value="num2", required = false) Integer num2) {
        return calculateService.Multiply(num1, num2);
    }
    @GetMapping(path ="/divide")
    public String divide(@RequestParam(value="num1", required = false) Integer num1,
                         @RequestParam(value="num2", required = false) Integer num2) {
        return calculateService.Division(num1, num2);
    }
}
