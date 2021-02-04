package br.com.alyson.brewer.service;

import br.com.alyson.brewer.model.Category;
import br.com.alyson.brewer.repository.CategoryRepository;
import br.com.alyson.brewer.service.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Category buscarPorNome(String name){

        // TODO: Verificar como tratar um Optional no Service
        Optional<Category> category = categoryRepository.findByName(name);
        if(category.isPresent()){
            return category.get();
        }else{
           return null;
        }

    }

    @Transactional
    public void salvar(Category category){
        if(!categoryRepository.findByName(category.getName()).isPresent())
                categoryRepository.save(category);
    }
}
