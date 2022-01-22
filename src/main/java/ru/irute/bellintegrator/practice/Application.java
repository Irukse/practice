package ru.irute.bellintegrator.practice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ru.irute.bellintegrator.practice.offise.controller.OfficeController;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDao;
import ru.irute.bellintegrator.practice.offise.dto.OfficeDto;
import ru.irute.bellintegrator.practice.organization.controller.OrganizationController;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;
import ru.irute.bellintegrator.practice.organization.servise.OrganizationService;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Locale;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2

@SpringBootApplication
public class Application {
@Bean
    ModelMapper modelMapper(){
    return new ModelMapper();
}
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
}