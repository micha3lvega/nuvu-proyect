package co.com.nuvu.credit.card.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("classpath:creditcard.properties")
public class CreditCardProperties {

	@Value("${encript.algorithm}")
	private String algorithm;

	@Value("${encript.salt}")
	private String salt;
}
