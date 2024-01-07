package com.github.riannegreiros.springcloud.springcloud.init;

import com.github.riannegreiros.springcloud.springcloud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedUsers();
    }

    private void seedUsers() {
        userService.createUser("Freddie Mercury", "freddie@mercury.com", "123456");
        userService.createUser("Diana Ross", "diana@ross.com", "123456");
        userService.createUser("Michael Jackson", "michael@jackson.com", "123456");
        userService.createUser("Celine Dion", "celine@dion.com", "123456");
    }
}
