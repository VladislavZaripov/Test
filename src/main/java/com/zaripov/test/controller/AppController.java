package com.zaripov.test.controller;

import com.zaripov.test.service.Converter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("test")
public class AppController {

    private final Converter converter;

    public AppController(Converter converter) {
        this.converter = converter;
    }

    @GetMapping("convert")
    public ResponseEntity<?> getNumbers(@RequestParam(value = "stringOfNumbers") String stringOfNumbers){
        try {
            String convertString = converter.convertString(stringOfNumbers);
            return ResponseEntity.ok(convertString);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping ("default")
    public ResponseEntity postN(@RequestBody String newN){
        try {
            converter.setN(newN);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}