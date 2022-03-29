package com.appgate.calculator.enums;

public enum EOperator {

    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    private EOperator(String operator){
        this.operator=operator;
    }

    public String getOperator() {
        return operator;
    }



}
