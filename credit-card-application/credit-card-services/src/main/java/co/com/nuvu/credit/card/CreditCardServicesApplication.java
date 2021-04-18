package co.com.nuvu.credit.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableEurekaClient
@EnableFeignClients
@EnableMongoAuditing
@SpringBootApplication
public class CreditCardServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardServicesApplication.class, args);
	}

}
