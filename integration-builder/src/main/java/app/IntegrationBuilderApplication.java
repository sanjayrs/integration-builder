package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = "app.entity")
public class IntegrationBuilderApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(IntegrationBuilderApplication.class, args);
	}

}
	