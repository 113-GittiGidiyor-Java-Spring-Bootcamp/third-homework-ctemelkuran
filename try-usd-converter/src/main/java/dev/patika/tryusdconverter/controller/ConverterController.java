package dev.patika.tryusdconverter.controller;

import dev.patika.tryusdconverter.repository.ConverterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ConverterController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConverterRepository repository;
}
