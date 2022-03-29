package com.appgate.calculator.services;


import com.appgate.calculator.dto.SessionDTO;
import com.appgate.calculator.enums.EOperator;
import com.appgate.calculator.request.AddCommandRequest;
import com.appgate.calculator.request.RunCalculatorRequest;
import com.appgate.calculator.responses.AddCommandResponse;
import com.appgate.calculator.responses.ResponseError;
import com.appgate.calculator.responses.GetEnvironmentResponse;
import com.appgate.calculator.responses.RunCalculatorResponse;
import com.appgate.calculator.utils.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class CalculatorService {

    private static Supplier<String> tokenSupplier;

    private static HashMap<String,SessionDTO> enviroments;

    static{
        tokenSupplier = () -> {

            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID().toString()).toString();
        };

        enviroments= new HashMap<String,SessionDTO>();
    }

    public CalculatorService(){

    }

    public Object getEnvironment(){

        Object response=null;

        try {

            GetEnvironmentResponse responseOK=new GetEnvironmentResponse();

            SessionDTO newSessionDTO =new SessionDTO(tokenSupplier.get());

            enviroments.put(newSessionDTO.getEnvironment(),newSessionDTO);

            responseOK.setEnvironment(newSessionDTO.getEnvironment());

            response=responseOK;

        }catch (Exception e){

            response=Utilities.getResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.toString());

        }

        return response;
    }

    public Object addCommand(AddCommandRequest request){

        Object response=null;
        ResponseError responseError=new ResponseError();
        response=responseError;

        try {



            SessionDTO oldSessionDTO = enviroments.get(request.getEnvironment());

            if (oldSessionDTO == null) {
                response=Utilities.getResponseError(HttpStatus.NOT_FOUND.value(),"Environment Fail " + request.getEnvironment() + " NOT_FOUND");

            } else {

                if(request.getNumber()==null||request.getNumber().isEmpty()){
                    response=Utilities.getResponseError(HttpStatus.BAD_REQUEST.value(),"Es obligatorio el campo number");

                }else{

                    Long number= Utilities.convertToLong(request.getNumber());
                    if(number==null){
                        response=Utilities.getResponseError(HttpStatus.BAD_REQUEST.value(),"El valor de number es incorrecto");

                    }else{
                        AddCommandResponse responseOK = new AddCommandResponse();
                        oldSessionDTO.getStack().push(Long.valueOf(request.getNumber()));
                        responseOK.setNumbers(oldSessionDTO.getStack());
                        response=responseOK;

                    }

                }

            }

        }catch (Exception e){
            response=Utilities.getResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.toString());

        }

       return response ;
    }

    public Object runCalculator(RunCalculatorRequest request){

        Object response=null;
        ResponseError responseError=new ResponseError();
        response=responseError;

        try {

            SessionDTO oldSessionDTO = enviroments.get(request.getEnvironment());

            if (oldSessionDTO == null) {
                response=Utilities.getResponseError(HttpStatus.NOT_FOUND.value(),"Sesion Fail " + request.getEnvironment() + " NOT_FOUND");

            } else {

                if(request.getOperator()==null||request.getOperator().isEmpty()){

                    response=Utilities.getResponseError(HttpStatus.BAD_REQUEST.value(),"Es obligatorio el campo operator");

                }else{
                    if(oldSessionDTO.getStack().size()>=2){


                        oldSessionDTO.getStack().push(Utilities.calculator(oldSessionDTO.getStack().pop(),
                                oldSessionDTO.getStack().pop(), EOperator.valueOf(request.getOperator())));

                        RunCalculatorResponse responseOK=new RunCalculatorResponse();
                        responseOK.setNumbers(oldSessionDTO.getStack());
                        responseOK.setResult(oldSessionDTO.getStack().peek());
                        response=responseOK;
                    }else{
                        response=Utilities.getResponseError(HttpStatus.NO_CONTENT.value(),"La pila no tiene numeros sufisientes para "+request.getOperator());

                    }

                }

            }

        }catch (Exception e) {
            response=Utilities.getResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.toString());
        }

        return response;
    }
}
