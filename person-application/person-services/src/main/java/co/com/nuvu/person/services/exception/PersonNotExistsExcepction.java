package co.com.nuvu.person.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "La persona no fue encontrada")
public class PersonNotExistsExcepction extends RuntimeException {

	private static final long serialVersionUID = -648345733589018505L;

}
