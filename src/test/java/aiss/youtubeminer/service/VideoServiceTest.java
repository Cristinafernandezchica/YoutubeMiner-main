package aiss.youtubeminer.service;


import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @Test
    void findAllVideos() {
        List<VideoSnippet> videos = videoService.findAllVideos("UC4pNDofN0Xh-z2bhh62g8Ow");
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(videos);
    }

}
