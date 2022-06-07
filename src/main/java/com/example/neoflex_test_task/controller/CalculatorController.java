package com.example.neoflex_test_task.controller;

import com.example.neoflex_test_task.exception.DivideByZeroException;
import com.example.neoflex_test_task.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("")
    public RedirectView home(){
        return new RedirectView("/swagger-ui.html");
    }

    @GetMapping("add")
    public ResponseEntity<?> add (
            @RequestParam Number a,
            @RequestParam Number b) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(calculatorService.add(a, b));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("sub")
    public ResponseEntity<?> sub (
            @RequestParam Number a,
            @RequestParam Number b) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(calculatorService.sub(a, b));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


    @GetMapping("div")
    public ResponseEntity<?> div (
            @RequestParam Number a,
            @RequestParam Number b) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(calculatorService.div(a, b));

        } catch (DivideByZeroException e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


    @GetMapping("mpy")
    public ResponseEntity<?> mpy(
            @RequestParam Number a,
            @RequestParam Number b) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(calculatorService.mpy(a, b));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
