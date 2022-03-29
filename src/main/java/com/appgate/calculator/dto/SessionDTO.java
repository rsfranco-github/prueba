package com.appgate.calculator.dto;

import com.appgate.calculator.enums.EOperator;

import java.util.Stack;

/**
 * Clase de sesion que permite agrupar la informacion generada para cada uno de los ambientes.
 */
public class SessionDTO {

    private String environment;
    private Stack<Long> stack;

    public SessionDTO(String environment){
        this.environment=environment;
        this.stack=new Stack<Long>();
    }


    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Stack<Long> getStack() {
        return stack;
    }

    public void setStack(Stack<Long> stack) {
        this.stack = stack;
    }



}
