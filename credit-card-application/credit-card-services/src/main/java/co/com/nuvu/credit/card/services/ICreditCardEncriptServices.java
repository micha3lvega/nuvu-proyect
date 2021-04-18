package co.com.nuvu.credit.card.services;

import co.com.nuvu.person.commons.dto.PersonDTO;

public interface ICreditCardEncriptServices {

	String encryptCreditCardNumber(PersonDTO person);

	String decriptCreditCardNumber(PersonDTO personDTO);

}
