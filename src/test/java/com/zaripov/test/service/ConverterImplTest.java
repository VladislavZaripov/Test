package com.zaripov.test.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ConverterImplTest {

    @Test
    void convertString() throws Exception{
        Converter converter = new ConverterImpl();

        String actual = converter.convertString("1,3,2");
        String expected = "2,4,3";

        assertEquals(expected,actual);
    }
}