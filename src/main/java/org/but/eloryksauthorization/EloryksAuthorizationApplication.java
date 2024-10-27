package org.but.eloryksauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@SpringBootApplication
public class EloryksAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EloryksAuthorizationApplication.class, args);
          Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16, 32, 1, 65536, 5);

        String pwd = passwordEncoder.encode("eloryks");
        System.out.println(pwd);
    }
}