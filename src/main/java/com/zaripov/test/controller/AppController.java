package com.zaripov.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("test")
public class AppController {

    static int N = 1;

    @GetMapping("convert")
    public ResponseEntity<?> getNumbers(@RequestParam(value = "stringOfNumbers") String stringOfNumbers){
        try {
            String convertString = Stream.of(stringOfNumbers.split(","))
                    .map(x -> Integer.parseInt(x) + N)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            return ResponseEntity.ok(convertString);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping ("default")
    public ResponseEntity postN(@RequestBody String newN){
        try {
            N = Integer.parseInt(newN);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}