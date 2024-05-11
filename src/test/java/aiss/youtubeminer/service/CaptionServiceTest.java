package aiss.youtubeminer.service;

import aiss.youtubeminer.model.caption.Caption;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.service.CaptionService;
import aiss.youtubeminer.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CaptionServiceTest {

    @Autowired
    CaptionService captionService;

    @Test
    void findAllCaptions() {
        List<Caption> captions = captionService.findAllCaptions("Y6GgkoAguwc");
        System.out.println(captions);
    }
}
