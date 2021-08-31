package dev.patika.schoolmanagement.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyEndPoint {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/convert-currency")
    public ResponseEntity<String> convert(@RequestParam String firstCurrency, @RequestParam String secondCurrency,
                                     @RequestParam double amount) {


        String result = restTemplate.getForEntity("http://localhost:8090/api/converter?firstCurrency="
                +firstCurrency + "&to="+secondCurrency+"&amount="+amount, String.class).getBody();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
