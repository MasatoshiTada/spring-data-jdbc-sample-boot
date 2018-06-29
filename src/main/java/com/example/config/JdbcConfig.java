package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.DataAccessStrategy;
import org.springframework.data.jdbc.core.DefaultDataAccessStrategy;
import org.springframework.data.jdbc.core.SqlGeneratorSource;
import org.springframework.data.jdbc.mapping.model.DelimiterNamingStrategy;
import org.springframework.data.jdbc.mapping.model.JdbcMappingContext;
import org.springframework.data.jdbc.mapping.model.NamingStrategy;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(basePackages = "com.example.repository")
public class JdbcConfig {

    @Bean
    public DataAccessStrategy dataAccessStrategy(JdbcMappingContext context) {
        return new DefaultDataAccessStrategy(new SqlGeneratorSource(context), context);
    }

    @Bean
    public NamingStrategy namingStrategy() {
        return new DelimiterNamingStrategy();
    }
}
