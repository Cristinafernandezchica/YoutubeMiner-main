package aiss.youtubeminer;

import aiss.youtubeminer.model.caption.Caption;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.service.CaptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CaptionServiceTest {
    @Autowired
    CaptionService captionService;

    @Test
    void findAll() {
        List<Caption> captions = captionService.findAllCaptions
                ("UC4pNDofN0Xh-z2bhh62g8Ow","Fv1W6X-X1d0");
        assertFalse(captions == null,"No se han encontrado los videos");
        System.out.println(captions);
    }
}
