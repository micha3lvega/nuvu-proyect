package co.com.nuvu.credit.card.exception.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.nuvu.credit.card.exception.ExceptionErrorInfo;

@ControllerAdvice
public class ErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionErrorInfo> methodArgumentNotValidException(HttpServletRequest request,
			MethodArgumentNotValidException e) {

		// get spring errors
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		// convert errors to standard string
		StringBuilder errorMessage = new StringBuilder();

		for (int i = 0; i < fieldErrors.size(); i++) {
			errorMessage.append(fieldErrors.get(i).getDefaultMessage());
			if ((fieldErrors.size() > 1) && (i < (fieldErrors.size() - 1))) {
				errorMessage.append(",");
			}
		}

		// return error info object with standard json
		ExceptionErrorInfo errorInfo = new ExceptionErrorInfo(HttpStatus.BAD_REQUEST.value(), errorMessage.toString(),
				request.getRequestURI());
		log.error("(MethodArgumentNotValidException) errorInfo: {}", errorInfo, e);
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

	}

}