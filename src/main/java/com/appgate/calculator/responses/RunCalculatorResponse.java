package com.appgate.calculator.responses;

import java.util.Stack;

public class RunCalculatorResponse{

    private Stack<Long> numbers;
    private Long result;

    public Stack<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(Stack<Long> numbers) {
        this.numbers = numbers;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
