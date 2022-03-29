package com.appgate.calculator.utils;

import com.appgate.calculator.enums.EOperator;
import com.appgate.calculator.responses.ResponseError;

public class Utilities {


    /**
     * Este método se encarga de convertir una cadena a numero
     * @param value hace referencia a la cadena de caracteres a convertir a long
     * @return Long
     */
    public static Long convertToLong(String value){
        Long number=null;
        try{
            number=Long.valueOf(value);
        }catch (Exception e){

        }
        return number;
    }

    /**
     * Este método se encarga calcular la operacion entre 2 numeros
     * @param n1 hace referencia al primer numero
     * @param n2 hace referencia al segundo numero
     * @param operator hace referencia la operacion que se desea realizar
     * @return Long
     */
    public static Long calculator(Long n1, Long n2, EOperator operator){
        Long value=null;
        if(operator==EOperator.ADD){
            value=n1+n2;
        }else if(operator==EOperator.DIVIDE){
            value=n1/n2;
        }else if(operator==EOperator.MULTIPLY){
            value=n1*n2;
        }else if(operator==EOperator.SUBSTRACT){
            value=n1-n2;
        }

        return value;
    }

    /**
     * Este método se encarga de generar un objecto response para error
     * @param status hace referencia codigo del error
     * @param error hace referencia al error en texto que se desea mostrar
     * @return ResponseError
     */
    public static ResponseError getResponseError(int status,String error){

        ResponseError responseError=new ResponseError();
        responseError.setStatus(status);
        responseError.setError(error);
        return responseError;

    }
}
