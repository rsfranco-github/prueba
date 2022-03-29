package com.appgate.calculator.responses;

import org.springframework.http.HttpStatus;

public class CalculatorResponse {

    private String version;
    private int status;
    private String error;

    public CalculatorResponse(){

            status=HttpStatus.OK.value();
            error=null;

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
