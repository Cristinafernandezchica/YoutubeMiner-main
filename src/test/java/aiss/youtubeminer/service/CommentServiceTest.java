package aiss.youtubeminer.service;

import aiss.youtubeminer.exceptions.CommentException;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    CommentService commentService;


    @Test
    void findAllComments() throws CommentException {
        List<Comment> comentarios = commentService.findAllComments("Y6GgkoAguwc", 10);
        System.out.println(comentarios);
    }

}
