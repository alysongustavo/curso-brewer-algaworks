package br.com.alyson.brewer.controller;

import br.com.alyson.brewer.model.Category;
import br.com.alyson.brewer.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView("category/cadastrar");
        LOGGER.debug("Log Configurado com sucesso nessa bagaça");
        return mv;
    }

    @RequestMapping("/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("category/listar");

        List<Category> categories = categoryService.listagemCategory();
        mv.addObject("categories", categories);
        LOGGER.debug("Quantidade de Categorias: " + categories.size());
        return mv;
    }

}
