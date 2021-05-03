package com.gwc.emp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
@Slf4j(topic = "HelloController")
@RestController
@RequestMapping("/hello")
public class HelloController{
    @GetMapping("/{name}")
    public void greetings(@PathVariable() String name){
        System.out.println("Hello "+name);
    }
}