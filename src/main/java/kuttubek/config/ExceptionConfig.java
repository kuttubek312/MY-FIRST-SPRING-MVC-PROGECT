//package kuttubek.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//import java.util.Properties;
//@Configuration
//public class ExceptionConfig {
//
//    @Bean(name = "simpleMappingExceptionResolver")
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//
//        Properties mappings = new Properties();
//        resolver.setExceptionMappings(mappings);
//        resolver.setExceptionAttribute("ErrorOccurred");
//        resolver.setDefaultErrorView("500");
//        return resolver;
//    }
//}
