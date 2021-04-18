package co.com.nuvu.credit.card.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiCreditCardApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
