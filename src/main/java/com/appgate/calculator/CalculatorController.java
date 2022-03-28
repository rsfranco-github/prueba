package com.appgate.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/calculator")
public class CalculatorController {

    @GetMapping(path = "getSession")
    public String getSession(){
        return "new getSession";
    }

    @GetMapping(path = "addCommand")
    public String addCommand(){
        return "set addCommand";
    }

    @GetMapping(path = "runCalculator")
    public String runCalculator(){
        return "send runCalculator";
    }
}
