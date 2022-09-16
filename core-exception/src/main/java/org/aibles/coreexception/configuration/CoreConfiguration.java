package org.aibles.coreexception.configuration;


import org.aibles.coreexception.util.HeaderLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class CoreConfiguration {
  @Bean
  public LocaleResolver localeResolver() {
    return new HeaderLocalResolver();
  }

}
