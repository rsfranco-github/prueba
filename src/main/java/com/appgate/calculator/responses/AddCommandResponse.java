package com.appgate.calculator.responses;

import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AddCommandResponse {

    private  Stack<Long> numbers;

    public Stack<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(Stack<Long> numbers) {
        this.numbers = numbers;
    }
}
