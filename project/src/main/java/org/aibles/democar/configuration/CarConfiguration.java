package org.aibles.democar.configuration;

import org.aibles.democar.repository.CarRepository;
import org.aibles.democar.service.CarService;
import org.aibles.democar.service.impl.CarServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.democar.repository"})
@ComponentScan(basePackages = {"org.aibles.democar.repository"})
public class CarConfiguration {
  @Bean
  public CarService carService(CarRepository repository) {
    return new CarServiceImpl(repository);
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/i18n/message");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
