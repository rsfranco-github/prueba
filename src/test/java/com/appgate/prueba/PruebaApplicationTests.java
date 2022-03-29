package com.appgate.prueba;

import com.appgate.calculator.services.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PruebaApplicationTests {

	@Mock
	private CalculatorService calculatorService;

	@Test
	void contextLoads() {
	}

}
