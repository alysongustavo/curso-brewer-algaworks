package br.com.alyson.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class IndexController {

    @GetMapping
    public ModelAndView dashboard(){
        return new ModelAndView("index/dashboard");
    }
}
