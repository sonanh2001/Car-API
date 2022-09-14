package org.aibles.democar.configuration;

import java.util.Locale;
import org.aibles.democar.repository.CarRepository;
import org.aibles.democar.service.CarService;
import org.aibles.democar.service.impl.CarServiceImpl;
import org.aibles.democar.utils.HeaderLocalResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.democar.repository"})
@ComponentScan(basePackages = {"org.aibles.democar.repository"})
public class CarConfiguration implements WebMvcConfigurer {
  @Bean
  public CarService carService(CarRepository repository) {
    return new CarServiceImpl(repository);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new HeaderLocalResolver();
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource
        = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename(
        "classpath:/i18n/message"
    );
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
