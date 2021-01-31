package br.com.alyson.brewer.service;

import br.com.alyson.brewer.model.Category;
import br.com.alyson.brewer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listagemCategory(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
