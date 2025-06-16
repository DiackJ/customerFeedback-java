package com.springboot.customerfeedback.Config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//fallback class to ensure env values are loaded upon program initialization
public class EnvLoader implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext appContext){
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        dotenv.entries().forEach(e -> {
            if(System.getProperty(e.getKey()) == null && System.getenv(e.getKey()) == null){
                System.setProperty(e.getKey(), e.getValue());
            }
        });
    }
}
