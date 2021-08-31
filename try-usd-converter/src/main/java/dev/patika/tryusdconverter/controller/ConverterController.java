package dev.patika.tryusdconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/converter")
public class ConverterController {

    // static currency rate
    static final double USD_TRY_RATE = 8.33;

    @GetMapping
    public ResponseEntity<String> convertCurrency(@RequestParam String firstCurrency,
                                                  @RequestParam String secondCurrency,
                                                  @RequestParam double amount)
    {
        if (firstCurrency.equalsIgnoreCase("try")
                && secondCurrency.equalsIgnoreCase("usd")) {
            return new ResponseEntity<>(String.format("USD to TRY: %.2f $", amount / USD_TRY_RATE), HttpStatus.OK);
        }
        else if (firstCurrency.equalsIgnoreCase("usd")
                && secondCurrency.equalsIgnoreCase("try")) {
            return new ResponseEntity<>(String.format("USD to TRY: %.2f ₺", amount * USD_TRY_RATE), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("An error occurred...", HttpStatus.BAD_REQUEST);
        }
    }

}
