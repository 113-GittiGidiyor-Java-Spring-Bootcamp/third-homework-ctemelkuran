package dev.patika.schoolmanagement.currency;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<String> convertTryAndUsd(@RequestParam String firstCurrency,
                                                   @RequestParam String secondCurrency,
                                                   @RequestParam double amount) {

        ResponseEntity<String> result = restTemplate.getForEntity(END_POINT_API+"/converter?firstCurrency="
                +firstCurrency + "&secondCurrency="+secondCurrency+"&amount="+ amount, String.class);

        return result;// ResponseEntity<>(result, HttpStatus.OK);
    }

}
