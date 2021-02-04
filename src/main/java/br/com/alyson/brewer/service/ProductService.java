package br.com.alyson.brewer.service;

import br.com.alyson.brewer.model.Product;
import br.com.alyson.brewer.repository.ProductRepository;
import br.com.alyson.brewer.service.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> todos(){
        return this.productRepository.findAll();
    }

    @Transactional
    public void salvar(Product product) throws NegocioException{

        Product productSearch = this.productRepository.findByNameIgnoreCase(product.getName());

        if(productSearch != null){
            throw new NegocioException("Produto existente");
        }

        this.productRepository.save(product);

    }

}
