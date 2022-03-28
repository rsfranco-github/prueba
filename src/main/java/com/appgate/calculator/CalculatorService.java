package com.appgate.calculator;


import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class CalculatorService {

    public Supplier<String> tokenSupplier;

    public CalculatorService(){

        tokenSupplier = () -> {

            StringBuilder token = new StringBuilder();
            long currentTimeInMilisecond = Instant.now().toEpochMilli();
            return token.append(currentTimeInMilisecond).append("-")
                    .append(UUID.randomUUID().toString()).toString();
        };

    }

    public String getSession(){
        return "new Session is "+tokenSupplier.get();
    }
}
