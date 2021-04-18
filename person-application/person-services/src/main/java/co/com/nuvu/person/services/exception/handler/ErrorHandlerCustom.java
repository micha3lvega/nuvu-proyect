package co.com.nuvu.person.services.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.com.nuvu.person.services.exception.ExceptionErrorInfo;


@ControllerAdvice
public class ErrorHandlerCustom {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionErrorInfo> methodArgumentNotValidException(HttpServletRequest request,
			RuntimeException e) {

		ResponseStatus responseStatus = null;
		for (int i = 0; i < e.getClass().getAnnotations().length; i++) {

			Object object = e.getClass().getAnnotations()[i];
			if (object instanceof ResponseStatus) {
				responseStatus = (ResponseStatus) object;

				ExceptionErrorInfo errorInfo = new ExceptionErrorInfo(responseStatus.code().value(),
						responseStatus.reason(), request.getRequestURI());
				// return error info object with standard json
				return new ResponseEntity<>(errorInfo, responseStatus.value());
			}

		}

		return null;
	}

}