package com.example.demo.configuration;

import com.example.demo.schema.BaseEntity;
import org.reflections.Reflections;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Set;

@Configuration
@EntityScan(basePackageClasses = {BaseEntity.class})
@EnableJpaRepositories(basePackages = "com.example.demo.repo.jpa")
public class TableRepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        Reflections tableEntity = new Reflections("com.example.demo.schema");
        Set<Class<? extends BaseEntity>> repositories = tableEntity.getSubTypesOf(BaseEntity.class);
        config.exposeIdsFor(repositories.toArray(new Class<?>[0]));
    }
}
