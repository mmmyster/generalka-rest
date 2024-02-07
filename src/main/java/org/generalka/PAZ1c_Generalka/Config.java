package org.generalka.PAZ1c_Generalka;

import org.generalka.PAZ1c_Generalka.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config {
    private final JdbcTemplate jdbcTemplate;

    @Value("${cors.allowedOrigins}")
    private String allowedOrigins;

    public Config(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public AnswerDao getAnswerDao() {
        return new MysqlAnswerDao(jdbcTemplate);
    }

    @Bean
    public TestDao getTestDao() {
        return new MysqlTestDao(jdbcTemplate);
    }

    @Bean
    public TestQuestionDao getTestQuestionDao() {
        return new MysqlTestQuestionDao(jdbcTemplate);
    }

    @Bean
    public WebMvcConfigurer corsComfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(allowedOrigins.split(",")).allowedMethods("*");
            }
        };
    }
}
