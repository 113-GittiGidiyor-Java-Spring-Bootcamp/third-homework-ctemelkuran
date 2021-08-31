package dev.patika.tryusdconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TryUsdConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryUsdConverterApplication.class, args);
    }


}
