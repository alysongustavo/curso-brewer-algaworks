package br.com.alyson.brewer.controller;

import br.com.alyson.brewer.model.Product;
import br.com.alyson.brewer.service.CategoryService;
import br.com.alyson.brewer.service.ProductService;
import br.com.alyson.brewer.service.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/cadastrar")
    public ModelAndView novo(Product product){
        ModelAndView mv = new ModelAndView("product/cadastrar");
        mv.addObject("categories", categoryService.listagemCategory());

        return mv;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Product product, BindingResult result, Model model, RedirectAttributes redirect){

        if(result.hasErrors()){
            return novo(product);
        }

        try{
            productService.salvar(product);
            redirect.addFlashAttribute("mensagem", "Produto cadastrado com sucesso");
            return new ModelAndView("redirect:/product/cadastrar");
        }catch (NegocioException negocioException){
            result.rejectValue("name", negocioException.getMessage(), negocioException.getMessage());
            return novo(product);
        }

    }

    @RequestMapping("/listar")
    public ModelAndView listar(){

        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.todos();
        mv.addObject("products", products);

        return mv;
    }
}
