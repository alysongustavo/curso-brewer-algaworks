package br.com.alyson.brewer.util;

import br.com.alyson.brewer.config.DBConfig;
import br.com.alyson.brewer.config.TestBeanConfig;
import br.com.alyson.brewer.config.WebConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

public class PropertiesReadTest {

    private PropertiesRead reader;

    @Before
    public void setup() throws IOException {
        reader = new PropertiesRead("properties-from-pom.properties");
    }

    @Test
    public void verificaPropriedadearquivo_Test(){
        String version = reader.getProperty("application.version");
        Assert.assertEquals("1.1-SNAPSHOT", version);
    }
}
