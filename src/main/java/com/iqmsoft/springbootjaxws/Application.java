package com.iqmsoft.springbootjaxws;

import com.revinate.ws.spring.SDDocumentCollector;
import com.revinate.ws.spring.SpringService;
import com.sun.xml.ws.transport.http.servlet.SpringBinding;
import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import com.iqmsoft.demo.service.FactorialPort;
import com.iqmsoft.demo.service.FibonacciPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

@SpringBootApplication
public class Application {

    private static final Collection<Object> DEMOSERVICE_METADATA;
    private static final Object DEMOSERVICE_PRIMARY_WSDL;

    static {
        ClassLoader cl = Application.class.getClassLoader();
        Map<URL, Object> docs = SDDocumentCollector.collectDocs("demo", cl);
        DEMOSERVICE_METADATA = docs.values();
        DEMOSERVICE_PRIMARY_WSDL = docs.get(cl.getResource("demo/wsdl/DemoService.wsdl"));
    }

    @Autowired
    private FibonacciPort fibonacciPort;

    @Autowired
    private FactorialPort factorialPort;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Servlet jaxwsServlet() {
        return new WSSpringServlet();
    }

    @Bean
    public ServletRegistrationBean jaxwsServletRegistration() {
        return new ServletRegistrationBean(jaxwsServlet(), "/service/*");
    }

    @Bean
    public SpringService fibonacciService() throws IOException {
        SpringService service = new SpringService();
        service.setBean(fibonacciPort);
        service.setServiceName(new QName("http://www.iqmsoft.com/demo", "DemoService"));
        service.setPortName(new QName("http://www.iqmsoft.com/demo", "FibonacciPort"));
        service.setMetadata(DEMOSERVICE_METADATA);
        service.setPrimaryWsdl(DEMOSERVICE_PRIMARY_WSDL);
        return service;
    }

    @Bean
    public SpringService factorialService() throws IOException {
        SpringService service = new SpringService();
        service.setBean(factorialPort);
        service.setServiceName(new QName("http://www.iqmsoft.com/demo", "DemoService"));
        service.setPortName(new QName("http://www.iqmsoft.com/demo", "FactorialPort"));
        service.setMetadata(DEMOSERVICE_METADATA);
        service.setPrimaryWsdl(DEMOSERVICE_PRIMARY_WSDL);
        return service;
    }

    @Bean
    public SpringBinding fibonacciBinding() throws Exception {
        SpringBinding binding = new SpringBinding();
        binding.setUrl("/service/fibonacci");
        binding.setService(fibonacciService().getObject());
        return binding;
    }

    @Bean
    public SpringBinding factorialBinding() throws Exception {
        SpringBinding binding = new SpringBinding();
        binding.setUrl("/service/factorial");
        binding.setService(factorialService().getObject());
        return binding;
    }
}
