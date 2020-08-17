package com.zaripov.test;

import com.zaripov.test.service.Converter;
import com.zaripov.test.service.ConverterImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
		Converter converter = new ConverterImpl();

		String actual = "1,3,2";
		String expected = "2,4,3";

		assertEquals(expected,actual);
	}

}
