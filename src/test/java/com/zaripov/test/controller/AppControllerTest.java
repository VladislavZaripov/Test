package com.zaripov.test.controller;

import com.zaripov.test.service.Converter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @Autowired
    @MockBean
    private Converter converter;

    @Test
    public void getNumbersOk() throws Exception{
        Mockito.when(converter.convertString("1,3,2")).thenReturn("2,4,31");

        mockMvc.perform(get("http://localhost:8080/test/convert")
                .param("stringOfNumbers", "1,3,2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2,4,3")));
    }

    @Test
    public void getNumbersBad() throws Exception{
        Mockito.when(converter.convertString("qwerty")).thenThrow(new Exception());

        mockMvc.perform(get("http://localhost:8080/test/convert")
                .param("stringOfNumbers", "qwerty"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void postNOk() throws Exception{
        Mockito.doNothing().when(converter).setN("2");

        mockMvc.perform(post("http://localhost:8080/test/default")
                .content("2"))
                .andExpect(status().isOk());
    }

    @Test
    public void postNBad() throws Exception{
        Mockito.doThrow(new Exception()).when(converter).setN("qwerty");

        mockMvc.perform(post("http://localhost:8080/test/default")
                .content("qwerty"))
                .andExpect(status().isBadRequest());
    }
}