package com.zaripov.test.service;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class ConverterImplTest {

    @Test
    void convertString() throws Exception{
        Converter converter = new ConverterImpl();

        String actual = converter.convertString("1,3,2");
        String expected = "2,4,31";

        assertEquals(expected,actual);
    }
}