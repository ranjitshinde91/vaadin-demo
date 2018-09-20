package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.UserService;
import service.impl.UserServiceImpl;

@Configuration
public class AppConfig {

    @Bean(name="userService")
    public UserService helloWorld() {
        return new UserServiceImpl();
    }
}