package aiss.youtubeminer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason= "Max videos must be an Integer equal to 0 or greater")
public class MaxVideosException extends Exception {
}