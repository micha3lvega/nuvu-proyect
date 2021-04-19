package co.com.nuvu.user.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "Error al validar las reglas de negocio")
public class UserBusinessException extends RuntimeException {

	public UserBusinessException() {

	}

	public UserBusinessException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -5799033044686856545L;

}
