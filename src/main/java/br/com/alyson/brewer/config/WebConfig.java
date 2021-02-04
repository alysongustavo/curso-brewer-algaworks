package br.com.alyson.brewer.config;

import br.com.alyson.brewer.Application;
import br.com.alyson.brewer.controller.converter.CategoryConverter;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {Application.class})
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");

        return thymeleafViewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setEnableSpringELCompiler(true);
        springTemplateEngine.setTemplateResolver(templateResolver());
        springTemplateEngine.addDialect(new LayoutDialect());

        return  springTemplateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(applicationContext);
        springResourceTemplateResolver.setPrefix("classpath:/templates/");
        springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
        springResourceTemplateResolver.setSuffix(".html");

        return springResourceTemplateResolver;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public FormattingConversionService mvcConversionService(){
        DefaultFormattingConversionService defaultFormattingConversionService =
                new DefaultFormattingConversionService();
        defaultFormattingConversionService.addConverter(new CategoryConverter());

        return defaultFormattingConversionService;
    }

    @Bean
    public DomainClassConverter<FormattingConversionService> domainClassConverter(){
        return new DomainClassConverter<FormattingConversionService>(mvcConversionService());
    }
}
