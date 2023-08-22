package com.example.demo.controller.health;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController public class HealthController {

   @RequestMapping("/health")

            public String checkAPI(){

       return "The API is working ok!";

   }
}