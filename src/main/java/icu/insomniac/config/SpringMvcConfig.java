package icu.insomniac.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"icu.insomniac.controller","icu.insomniac.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
