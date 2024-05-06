package aiss.youtubeminer.service;

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
    void findAllComments() {
        List<Comment> comentarios = commentService.findAllComments("UC4pNDofN0Xh-z2bhh62g8Ow", "Y6GgkoAguwc", 10);
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(comentarios);
    }

}
