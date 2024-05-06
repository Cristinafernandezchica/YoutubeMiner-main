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
        List<Caption> captions = captionService.findAllCaptions("UC4pNDofN0Xh-z2bhh62g8Ow", "Y6GgkoAguwc");
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(captions);
    }
}
