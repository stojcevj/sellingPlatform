package com.example.sellingPlatform.config;

import com.example.sellingPlatform.service.ProductService;
import com.example.sellingPlatform.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class DataInitailizer {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ProductService productService;

    public DataInitailizer(UserService userService, PasswordEncoder passwordEncoder, ProductService productService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.productService = productService;
    }

    @PostConstruct
    void initData() throws IOException {
       /* //userService.createUser("Jovan", "stojcevjovan@hotmail.com", passwordEncoder.encode("123"), UserAuthorities.USER);
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\stojc\\OneDrive\\Desktop\\Desktop\\carSelling-201080\\out.txt"));
        String line;
        while(true){
            line = br.readLine();
            if(line == null){
                return;
            }
            String [] breaks = line.split("}");
            productService.save(new Product(breaks[0], breaks[1], breaks[2]));
        }*/
    }
}
