package co.com.nuvu.credit.card.services;

import co.com.nuvu.credit.card.model.CreditCard;

public interface ICreditCardEncriptServices {

	String encryptCreditCardNumber(CreditCard creditCard);

	String decriptCreditCardNumber(CreditCard creditCard);

}
