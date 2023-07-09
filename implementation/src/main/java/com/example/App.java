package com.example;

import com.example.model.Gender;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    private final ProductRepository productRepository;

    public App(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Product product1 = new Product();
//
//        product1.setName("Nike uzun kollu");
//        product1.setColor("Beyaz");
//        product1.setGender(Gender.UNISEX);
//
//        Product product2 = new Product();
//
//        product2.setName("Puma uzun kollu");
//        product2.setColor("Siyah");
//        product2.setGender(Gender.MALE);
//
//        Product product3 = new Product();
//
//        product3.setName("Adidas uzun kollu");
//        product3.setColor("Pembe");
//        product3.setGender(Gender.FEMALE);
//
//        Product product4 = new Product();
//
//        product4.setName("Adidas Sweatshirt");
//        product4.setColor("Gri");
//        product4.setGender(Gender.UNISEX);
//
//        productRepository.saveAll(List.of(product1, product2, product3, product4));

    }
}
