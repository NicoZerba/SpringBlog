package it.marconi.SpringBlogZerbato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages={"it.marconi.entities"})
public class SpringBlogZerbatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBlogZerbatoApplication.class, args);
	}

}
