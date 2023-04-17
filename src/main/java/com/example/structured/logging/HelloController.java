package com.example.structured.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @GetMapping
    public void hello() {
        MDC.put("correlationId", UUID.randomUUID().toString());
        LOGGER.info("something to log");
    }
}
