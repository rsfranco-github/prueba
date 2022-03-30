package com.appgate.calculator;

import com.appgate.calculator.request.AddCommandRequest;
import com.appgate.calculator.request.RunCalculatorRequest;
import com.appgate.calculator.responses.AddCommandResponse;
import com.appgate.calculator.responses.GetEnvironmentResponse;
import com.appgate.calculator.responses.ResponseError;
import com.appgate.calculator.services.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class PruebaApplicationTests {

	@Autowired
	private CalculatorService calculatorService;

	public String environment;


	@Test
	void getEnvironment() {
		Object object=calculatorService.getEnvironment();

		assertEquals(true,object instanceof GetEnvironmentResponse);

	}

	@Test
	void addCommand() {
		Object object=  calculatorService.getEnvironment();

		if(object instanceof GetEnvironmentResponse){
			String environment=((GetEnvironmentResponse)object).getEnvironment();

			AddCommandRequest request=new AddCommandRequest();
			request.setEnvironment(environment);
			request.setNumber("44");

			Object object2=  calculatorService.addCommand(request);

			if(object2 instanceof ResponseError){
				assertTrue(false);
			}else{

				assertEquals(false,((AddCommandResponse)object2).getNumbers().isEmpty());
			}


		}else{
			assertTrue(false);
		}



	}

}
