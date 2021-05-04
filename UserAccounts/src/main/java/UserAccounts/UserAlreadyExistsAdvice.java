package UserAccounts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UserAlreadyExistsAdvice {

	@ResponseBody
	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String userAlreadyExistsHandler(UserAlreadyExistsException ex) {
		return ex.getMessage();
	}
}
