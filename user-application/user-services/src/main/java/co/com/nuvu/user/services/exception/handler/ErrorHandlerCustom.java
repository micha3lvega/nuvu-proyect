package co.com.nuvu.user.services.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.com.nuvu.user.services.exception.ExceptionErrorInfo;

@ControllerAdvice
public class ErrorHandlerCustom {

	private static final Logger log = LoggerFactory.getLogger(ErrorHandlerCustom.class);

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionErrorInfo> runtimeException(HttpServletRequest request, RuntimeException e) {

		ResponseStatus responseStatus = null;
		for (int i = 0; i < e.getClass().getAnnotations().length; i++) {

			Object object = e.getClass().getAnnotations()[i];
			if (object instanceof ResponseStatus) {
				responseStatus = (ResponseStatus) object;

				ExceptionErrorInfo errorInfo = new ExceptionErrorInfo(responseStatus.code().value(),
						responseStatus.reason(), request.getRequestURI());
				// return error info object with standard json
				log.error("(runtimeException) MethodArgumentNotValidException: {}", errorInfo, e);
				return new ResponseEntity<>(errorInfo, responseStatus.value());
			}

		}

		return null;
	}

}