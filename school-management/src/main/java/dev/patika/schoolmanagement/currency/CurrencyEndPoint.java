package dev.patika.schoolmanagement.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CurrencyEndPoint {

    // Field injection
    @Autowired
    RestTemplate restTemplate;

    // static end point url
    static final String END_POINT_API = "http://localhost:8090/api";

    // Get Request end point
    @GetMapping("/convert-currency")
    public ResponseEntity<String> convertTryAndUsd(@RequestParam String fromCurrency,
                                                   @RequestParam String toCurrency,
                                                   @RequestParam double amount) {

        ResponseEntity<String> result = restTemplate.getForEntity(END_POINT_API+"/converter?fromCurrency="
                + fromCurrency + "&toCurrency="+ toCurrency +"&amount="+ amount, String.class);

        return result;// ResponseEntity<>(result, HttpStatus.OK);
    }

}
