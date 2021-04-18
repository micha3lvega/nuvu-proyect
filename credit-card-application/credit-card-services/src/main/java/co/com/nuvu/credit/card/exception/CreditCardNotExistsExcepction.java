package co.com.nuvu.credit.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "La tarjeta de credito fue no encontrada")
public class CreditCardNotExistsExcepction extends RuntimeException {

	private static final long serialVersionUID = -648345733589018505L;

}
