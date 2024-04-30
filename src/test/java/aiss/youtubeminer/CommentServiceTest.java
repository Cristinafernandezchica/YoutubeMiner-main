package aiss.youtubeminer;

import aiss.youtubeminer.model.comment.CommentSearch;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    void findAll() {
        List<Comment> comments = commentService.findAll
                ("UC4pNDofN0Xh-z2bhh62g8Ow","Fv1W6X-X1d0");
        assertFalse(comments == null,"No se han encontrado los videos");
        System.out.println(comments);
    }

}
