package com.appgate.calculator.responses;

public class GetSessionResponse extends CalculatorResponse {

    private String sessionId;

    public GetSessionResponse(){
        super();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
