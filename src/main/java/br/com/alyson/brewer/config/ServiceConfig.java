package br.com.alyson.brewer.config;

import br.com.alyson.brewer.service.CategoryService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CategoryService.class)
public class ServiceConfig {

}
