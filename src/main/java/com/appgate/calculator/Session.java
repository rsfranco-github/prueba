package com.appgate.calculator;

import java.util.Stack;

public class Session {

    public String sessionId;
    public Stack<EOperator> operators;
    public Stack<Long> numbers;

    public Session(String sessionId){
        this.sessionId=sessionId;
        this.operators=new Stack<EOperator>();
        this.numbers=new Stack<Long>();
    }


}
