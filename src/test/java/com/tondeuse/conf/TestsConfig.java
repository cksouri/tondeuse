package com.tondeuse.conf;

import com.tondeuse.validator.ValidationBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootTest
public class TestsConfig {

    @Bean
    public ValidationBean instanceValidator(){
        return new ValidationBean();
    }
}
