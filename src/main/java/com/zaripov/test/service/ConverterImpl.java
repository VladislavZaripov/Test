package com.zaripov.test.service;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConverterImpl implements Converter {

    private static int N = 1;

    @Override
    public String convertString(String stringOfNumbers){
        return Stream.of(stringOfNumbers.split(","))
                .map(x -> Integer.parseInt(x) + getN())
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public void setN(String newN){
        N = Integer.parseInt(newN);
    }

    @Override
    public Integer getN() {
        return N;
    }
}