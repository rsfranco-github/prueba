package com.appgate.calculator.dto;

import com.appgate.calculator.enums.EOperator;

import java.util.Stack;

public class SessionDTO {

    private String sessionId;
    private Stack<Long> stack;
    private int length;

    public SessionDTO(String sessionId){
        this.sessionId=sessionId;
        this.stack=new Stack<Long>();
        this.length=0;
    }


    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Stack<Long> getStack() {
        return stack;
    }

    public void setStack(Stack<Long> stack) {
        this.stack = stack;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void push(Long item){
        this.stack.push(item);
        this.length++;
    }

    public Long pop(){
        this.length--;
        return this.stack.pop();


    }
}
