package com.techfusion.cms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.techfusion.cms.controller",
    "com.techfusion.cms.exception.handler"
})
public class WebConfig {
}