package com.devcalc.service;

import com.devcalc.entity.Calculation;
import com.devcalc.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculationRepository calculationRepository;

    @Autowired
    public CalculatorService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public double add(double a, double b) {
        double res = a + b;
        Calculation calc = new Calculation(a, b, "ADD", res);
        calculationRepository.save(calc);
        return res;
    }

    public double subtract(double a, double b) {
        double res = a - b;
        Calculation calc = new Calculation(a, b, "SUBTRACT", res);
        calculationRepository.save(calc);
        return res;
    }

    public double multiply(double a, double b) {
        double res = a * b;
        Calculation calc = new Calculation(a, b, "MULTIPLY", res);
        calculationRepository.save(calc);
        return res;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor não pode ser zero.");
        }
        double res = a / b;
        Calculation calc = new Calculation(a, b, "DIVIDE", res);
        calculationRepository.save(calc);
        return res;
    }

    public double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Não é possível calcular raiz quadrada de número negativo.");
        }
        double res = Math.sqrt(x);
        // Para rastrear consistência de entity, colocamos operandB = 0 e operação "SQRT"
        Calculation calc = new Calculation(x, 0, "SQRT", res);
        calculationRepository.save(calc);
        return res;
    }
}
