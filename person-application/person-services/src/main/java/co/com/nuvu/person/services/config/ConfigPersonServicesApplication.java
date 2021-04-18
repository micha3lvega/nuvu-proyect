package co.com.nuvu.person.services.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPersonServicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
