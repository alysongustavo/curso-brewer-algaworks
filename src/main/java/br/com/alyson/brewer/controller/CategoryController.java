package br.com.alyson.brewer.controller;

import br.com.alyson.brewer.model.Category;
import br.com.alyson.brewer.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/cadastrar")
    public ModelAndView novo(Category category){
        ModelAndView mv = new ModelAndView("category/cadastrar");
        LOGGER.debug("Log Configurado com sucesso nessa bagaça");
        return mv;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Category category, BindingResult result, Model model, RedirectAttributes attributes){

        attributes.addFlashAttribute("mensagem", "Categoria salva com sucesso");
        LOGGER.debug("Entrou no metodo cadastrar POST" + category.getName());
        return new ModelAndView("redirect:/category/cadastrar");
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
