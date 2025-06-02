package com.devcalc.controller;

import com.devcalc.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<Double> add(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b) {
        double result = calculatorService.add(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/subtract")
    public ResponseEntity<Double> subtract(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b) {
        double result = calculatorService.subtract(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> multiply(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b) {
        double result = calculatorService.multiply(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> divide(
            @RequestParam(name = "a") double a,
            @RequestParam(name = "b") double b) {
        try {
            double result = calculatorService.divide(a, b);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/sqrt")
    public ResponseEntity<Double> sqrt(
            @RequestParam(name = "x") double x) {
        try {
            double result = calculatorService.sqrt(x);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
