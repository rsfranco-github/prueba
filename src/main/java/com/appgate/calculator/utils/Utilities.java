package com.appgate.calculator.utils;

import com.appgate.calculator.enums.EOperator;

public class Utilities {

    public static Long convertToLong(String value){
        Long number=null;
        try{
            number=Long.valueOf(value);
        }catch (Exception e){

        }
        return number;
    }

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
}
