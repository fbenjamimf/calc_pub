package com.devcalc.entity;

import javax.persistence.*;

@Entity
@Table(name = "calculations")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double operandA;
    private double operandB;
    private String operation; // Ex: "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "SQRT"
    private double result;

    public Calculation() {}

    public Calculation(double operandA, double operandB, String operation, double result) {
        this.operandA = operandA;
        this.operandB = operandB;
        this.operation = operation;
        this.result = result;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public double getOperandA() {
        return operandA;
    }

    public void setOperandA(double operandA) {
        this.operandA = operandA;
    }

    public double getOperandB() {
        return operandB;
    }

    public void setOperandB(double operandB) {
        this.operandB = operandB;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
