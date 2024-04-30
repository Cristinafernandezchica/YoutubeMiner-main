package aiss.youtubeminer;

import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetDetails;
import aiss.youtubeminer.service.ChannelService;
import aiss.youtubeminer.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @Test
    void findAllVideos() {
        List<VideoSnippet> videos = videoService.findAllVideos("UC4pNDofN0Xh-z2bhh62g8Ow");
        assertFalse(videos == null,"No se han encontrado los videos");
        System.out.println(videos);
    }

    @Test
    void findOne() {
        VideoSnippetDetails videoSnippetDetails = videoService.findOne("UC4pNDofN0Xh-z2bhh62g8Ow", "Fv1W6X-X1d0");
        assertFalse(videoSnippetDetails == null,"No se ha encontrado el video");
        System.out.println(videoSnippetDetails);
    }


}
