package br.com.alyson.brewer.config.init;

import br.com.alyson.brewer.config.DBConfig;
import br.com.alyson.brewer.config.MetadataConfig;
import br.com.alyson.brewer.config.ServiceConfig;
import br.com.alyson.brewer.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DBConfig.class, ServiceConfig.class, MetadataConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
