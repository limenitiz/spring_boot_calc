package com.example.neoflex_test_task;

import com.example.neoflex_test_task.exception.DivideByZeroException;
import com.example.neoflex_test_task.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeoflexTestTaskApplicationTests {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("add_range_int [-100; 100]")
    void add_range_int() {
        int min_a = -100;
        int max_a = 100;
        int min_b = -100;
        int max_b = 100;
        for (int i = min_a; i < max_a; i++) {
            for (int j = min_b; j < max_b; j++) {
                assertEquals(
                        (double) (i + j),
                        calculatorService.add(i, j)
                );
            }
        }
    }

    @Test
    @DisplayName("add_range_double [-100.0; 100.0]")
    void add_range_double() {
        double min_a = -100.0;
        double max_a = 100.0;
        double min_b = -100.0;
        double max_b = 100.0;
        for (double i = min_a; i < max_a; i += 0.1) {
            for (double j = min_b; j < max_b; j += 0.1) {
                assertEquals(
                        (i + j),
                        calculatorService.add(i, j)
                );
            }
        }
    }

    @Test
    @DisplayName("sub_range_int [-100; 100]")
    void sub_range_int() {
        int min_a = -100;
        int max_a = 100;
        int min_b = -100;
        int max_b = 100;
        for (int i = min_a; i < max_a; i++) {
            for (int j = min_b; j < max_b; j++) {
                assertEquals(
                        (double) (i - j),
                        calculatorService.sub(i, j)
                );
            }
        }
    }

    @Test
    @DisplayName("sub_range_double [-100.0; 100.0]")
    void sub_range_double() {
        double min_a = -100.0;
        double max_a = 100.0;
        double min_b = -100.0;
        double max_b = 100.0;
        for (double i = min_a; i < max_a; i += 0.1) {
            for (double j = min_b; j < max_b; j += 0.1) {
                assertEquals(
                        (i - j),
                        calculatorService.sub(i, j)
                );
            }
        }
    }

    @Test
    @DisplayName("div_range_int [-100; 100]")
    void div_range_int() throws DivideByZeroException {
        double min_a = -100;
        double max_a = 100;
        double min_b = -100;
        double max_b = 100;
        for (double i = min_a; i < max_a; i++) {
            for (double j = min_b; j < max_b; j++) {
                if (j != 0) {
                    assertEquals(
                            (i / j),
                            calculatorService.div(i, j)
                    );
                }
            }
        }
    }

    @Test
    @DisplayName("div_range_double [-100.0; 100.0]")
    void div_range_double() throws DivideByZeroException {
        double min_a = -100.0;
        double max_a = 100.0;
        double min_b = -100.0;
        double max_b = 100.0;
        for (double i = min_a; i < max_a; i += 0.1) {
            for (double j = min_b; j < max_b; j += 0.1) {
                if (j != 0) {
                    assertEquals(
                            (i / j),
                            calculatorService.div(i, j)
                    );
                }
            }
        }
    }

    @Test
    @DisplayName("mpy_range_int [-100; 100]")
    void mpy_range_int() {
        int min_a = -100;
        int max_a = 100;
        int min_b = -100;
        int max_b = 100;
        for (int i = min_a; i < max_a; i++) {
            for (int j = min_b; j < max_b; j++) {
                assertEquals(
                        (double) (i * j),
                        calculatorService.mpy(i, j)
                );
            }
        }
    }

    @Test
    @DisplayName("mpy_range_double [-100.0; 100.0]")
    void mpy_range_double() {
        double min_a = -100.0;
        double max_a = 100.0;
        double min_b = -100.0;
        double max_b = 100.0;
        for (double i = min_a; i < max_a; i += 0.1) {
            for (double j = min_b; j < max_b; j += 0.1) {
                assertEquals(
                        (i * j),
                        calculatorService.mpy(i, j)
                );
            }
        }
    }
}
