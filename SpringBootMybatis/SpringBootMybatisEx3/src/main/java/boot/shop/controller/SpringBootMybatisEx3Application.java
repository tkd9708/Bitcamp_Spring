package boot.shop.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.shop.*", "boot.react"})
public class SpringBootMybatisEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisEx3Application.class, args);
	}

}
