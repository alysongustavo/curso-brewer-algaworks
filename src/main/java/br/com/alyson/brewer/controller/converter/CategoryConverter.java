package br.com.alyson.brewer.controller.converter;

import br.com.alyson.brewer.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class CategoryConverter implements Converter<Integer, Category> {

    @Override
    public Category convert(Integer s) {

        if(!StringUtils.isEmpty(s)){
            Category category = new Category();
            category.setId(s);
            return category;
        }

        return null;
    }
}
