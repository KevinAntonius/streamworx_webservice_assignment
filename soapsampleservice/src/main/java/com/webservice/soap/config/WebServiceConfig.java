package com.webservice.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/external/services/ws/*");
    }

    @Bean(name = "soap")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema soapSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("soapPort");
        wsdl11Definition.setLocationUri("/external/services/ws/sample-service");
        wsdl11Definition.setTargetNamespace("http://www.oracle.com/external/services/sampleservice/request/v1.0");
        wsdl11Definition.setSchema(soapSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapSchema() {
        return new SimpleXsdSchema(new ClassPathResource("soap.xsd"));
    }


}
