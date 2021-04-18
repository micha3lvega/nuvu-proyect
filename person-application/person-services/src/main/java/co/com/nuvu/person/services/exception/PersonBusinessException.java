package co.com.nuvu.person.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "Error al validar las reglas de negocio")
public class PersonBusinessException extends RuntimeException {

	public PersonBusinessException() {

	}

	public PersonBusinessException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -5799033044686856545L;

}
