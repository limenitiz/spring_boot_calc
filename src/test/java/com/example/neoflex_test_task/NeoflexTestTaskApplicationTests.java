package com.example.neoflex_test_task;

import com.example.neoflex_test_task.exception.DivideByZeroException;
import com.example.neoflex_test_task.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeoflexTestTaskApplicationTests {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    void add_int_int() {
        assertEquals(2.0, calculatorService.add(1, 1));
        assertEquals(0.0, calculatorService.add(-1, 1));
        assertEquals(-2.0, calculatorService.add(-1, -1));
    }

    @Test
    void add_int_double() {
        assertEquals(2.5, calculatorService.add(1, 1.5));
        assertEquals(0.5, calculatorService.add(-1, 1.5));
        assertEquals(-2.5, calculatorService.add(-1, -1.5));
    }

    @Test
    void sub_int_int() {
        assertEquals(0.0, calculatorService.sub(1, 1));
        assertEquals(-2.0, calculatorService.sub(-1, 1));
        assertEquals(0.0, calculatorService.sub(-1, -1));
    }

    @Test
    void sub_int_double() {
        assertEquals(-0.5, calculatorService.sub(1, 1.5));
        assertEquals(-2.5, calculatorService.sub(-1, 1.5));
        assertEquals(0.5, calculatorService.sub(-1, -1.5));
    }

    @Test
    void div_int_int() throws DivideByZeroException {
        assertThrows(DivideByZeroException.class, () -> calculatorService.div(0, 0));
        assertThrows(DivideByZeroException.class, () -> calculatorService.div(1, 0));

        assertEquals(0.0, calculatorService.div(0, 1));
        assertEquals(1.0, calculatorService.div(2, 2));
        assertEquals(0.5, calculatorService.div(2, 4));
        assertEquals(2.0, calculatorService.div(4, 2));
        assertEquals(-1.0, calculatorService.div(2, -2));
        assertEquals(-0.5, calculatorService.div(2, -4));
        assertEquals(-2.0, calculatorService.div(4, -2));
        assertEquals(-1.0, calculatorService.div(-2, 2));
        assertEquals(-0.5, calculatorService.div(-2, 4));
        assertEquals(-2.0, calculatorService.div(-4, 2));
        assertEquals(1.0, calculatorService.div(-2, -2));
        assertEquals(0.5, calculatorService.div(-2, -4));
        assertEquals(2.0, calculatorService.div(-4, -2));
    }

    @Test
    void mpy_int_int() {
        assertEquals(0.0, calculatorService.mpy(0, 0));
        assertEquals(0.0, calculatorService.mpy(1, 0));
        assertEquals(0.0, calculatorService.mpy(0, 1));

        assertEquals(0.0, calculatorService.mpy(0, 1));
        assertEquals(0.0, calculatorService.mpy(1, 0));
        assertEquals(4.0, calculatorService.mpy(2, 2));
        assertEquals(8.0, calculatorService.mpy(2, 4));
        assertEquals(8.0, calculatorService.mpy(4, 2));
        assertEquals(-4.0, calculatorService.mpy(2, -2));
        assertEquals(-8.0, calculatorService.mpy(2, -4));
        assertEquals(-8.0, calculatorService.mpy(4, -2));
        assertEquals(-4.0, calculatorService.mpy(-2, 2));
        assertEquals(-8.0, calculatorService.mpy(-2, 4));
        assertEquals(-8.0, calculatorService.mpy(-4, 2));
        assertEquals(4.0, calculatorService.mpy(-2, -2));
        assertEquals(8.0, calculatorService.mpy(-2, -4));
        assertEquals(8.0, calculatorService.mpy(-4, -2));
    }

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
