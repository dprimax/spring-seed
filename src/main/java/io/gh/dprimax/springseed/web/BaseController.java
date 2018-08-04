package io.gh.dprimax.springseed.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.gh.dprimax.springseed.constant.ResponseStatus;
import io.gh.dprimax.springseed.dto.ResponseWrapper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class BaseController {

	@Setter(value = AccessLevel.PRIVATE)
	@Getter(value = AccessLevel.PRIVATE)
	private ResponseEntity<Object> response = null;

	public ResponseEntity<Object> buildResponseGeneralSuccess() {
		return buildResponseGeneralSuccess(null);
	}
	
	public ResponseEntity<Object> buildResponseGeneralError() {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(null, ResponseStatus.GENERAL_ERROR), HttpStatus.INTERNAL_SERVER_ERROR));
		return this.response;
	}
	
	public ResponseEntity<Object> buildResponseGeneralSuccess(Object data) {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, ResponseStatus.GENERAL_SUCCESS), HttpStatus.OK));
		return this.response;
	}
	
	public ResponseEntity<Object> buildResponse(Object data, ResponseStatus responseStatus, HttpStatus httpStatus) {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, responseStatus), httpStatus));
		return this.response;
	}

	public ResponseEntity<Object> buildResponse(Object data, String code, String message, HttpStatus httpStatus) {
		setResponse(new ResponseEntity<Object>(ResponseWrapper.build(data, code, message), httpStatus));
		return this.response;
	}

//	public void validate(BindingResult bindingResult) throws FieldValidationException {
//		if (bindingResult.hasErrors()) {
//			FieldError fieldError = bindingResult.getFieldError();
//			throw new FieldValidationException(fieldError.getField() + " " + fieldError.getDefaultMessage());
//		}
//	}

}
