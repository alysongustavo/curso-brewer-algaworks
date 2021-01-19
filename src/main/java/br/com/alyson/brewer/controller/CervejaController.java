package br.com.alyson.brewer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cerveja")
public class CervejaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CervejaController.class);

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView("cerveja/cadastrar");
        LOGGER.info("Log Configurado com sucesso nessa bagaça");
        return mv;
    }

}
