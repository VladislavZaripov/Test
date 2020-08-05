package com.zaripov.test.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetNumbers() throws Exception{
        mockMvc.perform(get("http://localhost:8080/test/convert")
                .param("stringOfNumbers", "1,3,2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2,4,3")));

        mockMvc.perform(get("http://localhost:8080/test/convert")
                .param("stringOfNumbers", "qwerty"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testPostN() throws Exception{
        mockMvc.perform(post("http://localhost:8080/test/default")
                .content("2"))
                .andExpect(status().isOk());

        mockMvc.perform(post("http://localhost:8080/test/default")
                .content("qwerty"))
                .andExpect(status().isBadRequest());
    }
}