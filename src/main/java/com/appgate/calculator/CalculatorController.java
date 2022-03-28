package com.appgate.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }

    @GetMapping(path = "getSession")
    public String getSession(){
        return calculatorService.getSession();
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
