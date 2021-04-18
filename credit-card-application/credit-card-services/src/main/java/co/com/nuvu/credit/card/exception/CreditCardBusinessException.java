package co.com.nuvu.credit.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "Error de validacion de reglas de negocio")
public class CreditCardBusinessException extends RuntimeException {

	public CreditCardBusinessException() {

	}

	public CreditCardBusinessException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -5799033044686856545L;

}
