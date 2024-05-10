package aiss.youtubeminer.exceptions;

import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;


@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Comments disabled")
public class CommentException extends Exception {
    public List<Comment> DisableCommentException(){
        return new ArrayList<Comment>();
    }


}

