package aiss.youtubeminer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason= "Max comments must be an Integer equal to 0 or greater")
public class MaxCommentsException extends Exception {
}
