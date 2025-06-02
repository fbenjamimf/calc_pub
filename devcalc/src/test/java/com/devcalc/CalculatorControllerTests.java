package com.devcalc;

import com.devcalc.controller.CalculatorController;
import com.devcalc.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        // define comportamento padrão do service para cada operação
        when(calculatorService.add(anyDouble(), anyDouble())).thenReturn(15.0);
        when(calculatorService.subtract(anyDouble(), anyDouble())).thenReturn(5.0);
        when(calculatorService.multiply(anyDouble(), anyDouble())).thenReturn(50.0);
        when(calculatorService.divide(anyDouble(), anyDouble())).thenReturn(2.0);
        when(calculatorService.sqrt(anyDouble())).thenReturn(4.0);
    }

    @Test
    public void testAddEndpoint() throws Exception {
        mockMvc.perform(get("/add")
                .param("a", "10")
                .param("b", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }

    @Test
    public void testSubtractEndpoint() throws Exception {
        mockMvc.perform(get("/subtract")
                .param("a", "10")
                .param("b", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testMultiplyEndpoint() throws Exception {
        mockMvc.perform(get("/multiply")
                .param("a", "10")
                .param("b", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("50.0"));
    }

    @Test
    public void testDivideEndpoint() throws Exception {
        mockMvc.perform(get("/divide")
                .param("a", "10")
                .param("b", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    public void testDivideByZeroBadRequest() throws Exception {
        when(calculatorService.divide(10.0, 0.0)).thenThrow(new IllegalArgumentException());
        mockMvc.perform(get("/divide")
                .param("a", "10")
                .param("b", "0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSqrtEndpoint() throws Exception {
        mockMvc.perform(get("/sqrt")
                .param("x", "16")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("4.0"));
    }

    @Test
    public void testSqrtNegativeBadRequest() throws Exception {
        when(calculatorService.sqrt(-1.0)).thenThrow(new IllegalArgumentException());
        mockMvc.perform(get("/sqrt")
                .param("x", "-1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
