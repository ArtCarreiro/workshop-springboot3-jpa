package com.amc.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;
import java.time.Instant;

import com.amc.workshop.entities.Order;
import com.amc.workshop.entities.User;
import com.amc.workshop.repositories.OrderRepository;
import com.amc.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User us1 = new User(null, "Maria", "mariadb@gmail.com", "318124731", "senhadamaria");
        User us2 = new User(null, "Pedro", "Pedrodb@gmail.com", "314791617", "senhadopedro");
        User us3 = new User(null, "Joana", "Joanadb@gmail.com", "318167319", "senhadaJoana");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), us1); 
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), us2); 
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), us3);

        userRepository.saveAll(Arrays.asList(us1, us2, us3));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
