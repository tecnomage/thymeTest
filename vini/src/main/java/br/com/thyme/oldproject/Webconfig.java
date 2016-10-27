package br.com.thyme.oldproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc					
@ComponentScan(basePackages = {"br.com.thyme.oldproject", "br.com.thyme.boot"})
public class Webconfig extends WebMvcConfigurerAdapter {

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources").addResourceLocations("/resources/**");
		super.addResourceHandlers(registry);
	}	
	
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
	}

	
	@Bean 
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix("html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(1);
        return resolver;
    }
	
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySources = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[] { 
                new ClassPathResource("application.properties") };
        propertySources.setLocations(resources);
        propertySources.setIgnoreUnresolvablePlaceholders(true);
        return propertySources;
    }
	

    @Bean 
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());

//        //add spring security dialect
//        Set<IDialect> dialects = new HashSet<IDialect>();
//        dialects.add(springSecurityDialect());
//        engine.setAdditionalDialects(dialects);

        return engine;
    }

    @Bean 
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }
	
	
	
	
}
