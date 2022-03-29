package com.appgate.calculator.services;


import com.appgate.calculator.dto.SessionDTO;
import com.appgate.calculator.enums.EOperator;
import com.appgate.calculator.request.AddCommandRequest;
import com.appgate.calculator.request.RunCalculatorRequest;
import com.appgate.calculator.responses.AddCommandResponse;
import com.appgate.calculator.responses.GetSessionResponse;
import com.appgate.calculator.responses.RunCalculatorResponse;
import com.appgate.calculator.utils.Utilities;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.netty.http.server.HttpServerState;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class CalculatorService {

    private static Supplier<String> tokenSupplier;

    private static HashMap<String,SessionDTO> sessions;

    static{
        tokenSupplier = () -> {

            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID().toString()).toString();
        };

       sessions= new HashMap<String,SessionDTO>();
    }

    public CalculatorService(){

    }

    public GetSessionResponse getSession(){

        GetSessionResponse response=new GetSessionResponse();

        SessionDTO newSessionDTO =new SessionDTO(tokenSupplier.get());

        sessions.put(newSessionDTO.getSessionId(),newSessionDTO);

        response.setSessionId(newSessionDTO.getSessionId());

        return response;
    }

    public AddCommandResponse addCommand(AddCommandRequest request){

        AddCommandResponse response = new AddCommandResponse();

        try {

            SessionDTO oldSessionDTO = sessions.get(request.getSessionId());

            if (oldSessionDTO == null) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setError("Sesion Fail " + request.getSessionId() + " no encontrada");
            } else {

                if(request.getNumber()==null||request.getNumber().isEmpty()){
                    response.setStatus(HttpStatus.BAD_REQUEST.value());
                    response.setError("Es obligatorio el campo number");
                }else{

                    Long number= Utilities.convertToLong(request.getNumber());
                    if(number==null){
                        response.setStatus(HttpStatus.BAD_REQUEST.value());
                        response.setError("El valor de number es incorrecto");
                    }else{
                        oldSessionDTO.push(Long.valueOf(request.getNumber()));

                    }

                }

            }

        }catch (Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(e.toString());
        }

       return response ;
    }

    public RunCalculatorResponse runCalculator(RunCalculatorRequest request){

        RunCalculatorResponse response=new RunCalculatorResponse();

        try {

            SessionDTO oldSessionDTO = sessions.get(request.getSessionId());

            if (oldSessionDTO == null) {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setError("Sesion Fail " + request.getSessionId() + " no encontrada");
            } else {

                if(request.getOperator()==null||request.getOperator().isEmpty()){
                    response.setStatus(HttpStatus.BAD_REQUEST.value());
                    response.setError("Es obligatorio el campo operator");
                }else{
                    if(oldSessionDTO.getLength()>=2){


                        oldSessionDTO.push(Utilities.calculator(oldSessionDTO.pop(),
                                oldSessionDTO.pop(), EOperator.valueOf(request.getOperator())));

                        response.setError(""+oldSessionDTO.getStack().peek());
                    }else{
                        response.setStatus(HttpStatus.NO_CONTENT.value());
                        response.setError("La pila no tiene numeros sufisientes para "+request.getOperator());
                    }

                }

            }

        }catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setError(e.toString());
        }

        return response;
    }
}
