package br.com.alyson.brewer.config;

import br.com.alyson.brewer.util.PropertiesRead;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import java.io.IOException;

@Configuration
public class MetadataConfig {

    @Bean
    public PropertiesRead obterPropertiesRead() throws IOException {
        return new PropertiesRead("properties-from-pom.properties");
    }

    @Bean(name = "versao")
    public InformacaoAplicacao obterVersaoAplicacao(PropertiesRead propertiesRead){
        return (p) -> propertiesRead.getProperty(p);
    }

    @Bean(name = "aplicacao")
    public InformacaoAplicacao obterAmbienteAplicacao(PropertiesRead propertiesRead){
        return (p) -> propertiesRead.getProperty(p);
    }

    public interface InformacaoAplicacao {
        String buildInformation(String variable);
    }
}
