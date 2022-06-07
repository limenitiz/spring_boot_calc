package com.example.neoflex_test_task.service;

import com.example.neoflex_test_task.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Number add(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }

    public Number sub(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

    public Number div(Number a, Number b) throws DivideByZeroException {
        if (b.doubleValue() == 0.0) {
            throw new DivideByZeroException("Попытка деления на ноль. " +
                    "Деление на ноль дает неопределенный результат.");
        }

        return a.doubleValue() / b.doubleValue();
    }

    public Number mpy(Number a, Number b) {
        if (a.equals(0) || b.equals(0)) {
            return 0.0;
        }
        return a.doubleValue() * b.doubleValue();
    }
}
