package com.dev.cicd.data;

import java.util.Locale;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

        @GetMapping("/")
        public String healthCheck() {
                return "Spring Boot App Running Successfully";
        }
        
        @GetMapping("/greet")
        public String greet() {
                return "Hello Greet Controller";
        }

        @GetMapping("/version")
        public String version() {
                return "The actual version is 1.0.0";
        }

        @GetMapping("/nations")
        public JsonNode getRandomNations() {
                var objectMapper = new ObjectMapper();
                var faker = new Faker(new Locale("en-US"));
                var nations = objectMapper.createArrayNode();
                for (var i = 0; i < 10; i++) {
                        var nation = faker.nation();
                        nations.add(objectMapper.createObjectNode()
                                .put("nationality", nation.nationality())
                                .put("language", nation.language()));
                }
                return nations;
        }

        @GetMapping("/currencies")
        public JsonNode getRandomCurrencies() {
                var objectMapper = new ObjectMapper();
                var faker = new Faker(new Locale("en-US"));
                var currencies = objectMapper.createArrayNode();
                for (var i = 0; i < 20; i++) {
                        var currency = faker.currency();
                        currencies.add(objectMapper.createObjectNode()
                                .put("name", currency.name())
                                .put("code", currency.code()));
                }
                return currencies;

        }
        
        

}
