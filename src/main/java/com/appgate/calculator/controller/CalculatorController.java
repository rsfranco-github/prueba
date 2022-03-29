package com.appgate.calculator.controller;

import com.appgate.calculator.request.AddCommandRequest;
import com.appgate.calculator.request.RunCalculatorRequest;
import com.appgate.calculator.responses.AddCommandResponse;
import com.appgate.calculator.responses.GetSessionResponse;
import com.appgate.calculator.responses.RunCalculatorResponse;
import com.appgate.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }

    @GetMapping(path = "getSession")
    public GetSessionResponse getSession(){
        return calculatorService.getSession();
    }

    @PostMapping(path = "addCommand",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddCommandResponse addCommand(@RequestBody AddCommandRequest request){
        return calculatorService.addCommand(request);
    }

    @GetMapping(path = "runCalculator",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RunCalculatorResponse runCalculator(@RequestBody RunCalculatorRequest request){

        return calculatorService.runCalculator(request);
    }

}
