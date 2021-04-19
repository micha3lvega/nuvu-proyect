package co.com.nuvu.user.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Usuario o contraseña incorrectas")
public class UserLoginException extends RuntimeException {

	private static final long serialVersionUID = 5778279023754380036L;

	public UserLoginException() {

	}

	public UserLoginException(String message) {
		super(message);
	}

}
