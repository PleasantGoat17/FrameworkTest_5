package test.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "test.user")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();  
        templateResolver.setPrefix("/templates/");  
        templateResolver.setSuffix(".html");  
        templateResolver.setTemplateMode("HTML");  
        templateResolver.setCharacterEncoding("UTF-8");  
        return templateResolver;  
    }  
  
    @Bean  
    public SpringTemplateEngine templateEngine() {  
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();  
        templateEngine.setTemplateResolver(templateResolver());  
        return templateEngine;  
    }  
  
    @Bean  
    public ThymeleafViewResolver viewResolver() {  
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();  
        viewResolver.setTemplateEngine(templateEngine());  
        return viewResolver;  
    }  
  
    @Override  
    public void configureViewResolvers(ViewResolverRegistry registry) {  
        registry.viewResolver(viewResolver());  
    }


}