package pl.coderslab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.service.MemoryBookService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.coderslab", "pl.coderslab.controller", "pl.coderslab.model", "pl.coderslab.service"})
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public MemoryBookService memoryBookService() {
        return new MemoryBookService();
    }
}
