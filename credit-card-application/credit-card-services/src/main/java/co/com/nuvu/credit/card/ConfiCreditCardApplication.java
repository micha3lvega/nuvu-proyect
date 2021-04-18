package co.com.nuvu.credit.card;

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
