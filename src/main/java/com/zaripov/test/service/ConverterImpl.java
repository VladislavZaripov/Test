package com.zaripov.test.service;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConverterImpl implements Converter {

    static int N = 1;

    @Override
    public String convertString(String stringOfNumbers) throws Exception{
        String convertString = Stream.of(stringOfNumbers.split(","))
                .map(x -> Integer.parseInt(x) + N)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        return convertString;
    }

    @Override
    public void setN(String newN) throws Exception{
        N = Integer.parseInt(newN);
    }
}
