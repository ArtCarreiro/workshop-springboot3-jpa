package com.amc.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.util.Arrays;
import java.time.Instant;

import com.amc.workshop.entities.Category;
import com.amc.workshop.entities.Order;
import com.amc.workshop.entities.OrderItem;
import com.amc.workshop.entities.Product;
import com.amc.workshop.entities.User;
import com.amc.workshop.entities.enums.OrderStatus;
import com.amc.workshop.repositories.CategoryRepository;
import com.amc.workshop.repositories.OrderItemRepository;
import com.amc.workshop.repositories.OrderRepository;
import com.amc.workshop.repositories.ProductRepository;
import com.amc.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User us1 = new User(null, "Maria", "mariadb@gmail.com", "318124731", "senhadamaria");
        User us2 = new User(null, "Pedro", "Pedrodb@gmail.com", "314791617", "senhadopedro");
        User us3 = new User(null, "Joana", "Joanadb@gmail.com", "318167319", "senhadaJoana");

        userRepository.saveAll(Arrays.asList(us1, us2, us3));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, us1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, us2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, us3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category ct1 = new Category(null, "Eletronics");
        Category ct2 = new Category(null, "Books");
        Category ct3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(ct1, ct2, ct3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p3 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p4 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        Product p5 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(ct2);
        p2.getCategories().add(ct1);
        p2.getCategories().add(ct3);
        p3.getCategories().add(ct3);
        p4.getCategories().add(ct3);
        p5.getCategories().add(ct2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
