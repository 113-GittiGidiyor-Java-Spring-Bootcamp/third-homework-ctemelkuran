package dev.patika.tryusdconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConverterController {


    @GetMapping("/converter")
    public ResponseEntity<String> convertCurrency(@RequestParam String firstCurrency, @RequestParam String secondCurrency,
                                             @RequestParam double amount)
    {
        if (firstCurrency=="TRY"){
            return new ResponseEntity<>("TRY to USD: "+ amount / 8.45, HttpStatus.OK);
        }
        else if (firstCurrency=="USD"){
            return new ResponseEntity<>("USD to TRY: "+ amount * 8.45, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }
}
