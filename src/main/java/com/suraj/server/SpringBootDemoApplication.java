package com.suraj.server;

import java.util.Arrays;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.suraj.server")
@PropertySource("classpath:database.properties")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootDemoApplication {

  @Autowired Environment environment;

  /*private final String URL = "url";
  private final String USER = "dbuser";
  private final String DRIVER = "driver";
  private final String PASSWORD = "dbpassword";*/

  /*@Bean
  DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setUrl(environment.getProperty(URL));
    driverManagerDataSource.setUsername(environment.getProperty(USER));
    driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
    driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
    return driverManagerDataSource;
  }*/

  @Bean
  SessionFactory Session() {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
    final Metadata metadata = new MetadataSources(registry).buildMetadata();
//    final SessionFactory sessionFactory = metadata.buildSessionFactory();
    return metadata.buildSessionFactory();
  }

  public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);

        String[] beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);

        for (String beanName : beanNames)
        {
//          System.out.println(beanName);
        }
    }
}