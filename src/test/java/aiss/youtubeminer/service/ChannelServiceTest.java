package aiss.youtubeminer.service;

import aiss.youtubeminer.exceptions.CommentException;
import aiss.youtubeminer.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.service.ChannelService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChannelServiceTest {
    @Autowired
    ChannelService channelService;


    @Test
    void findOneChannel() throws NotFoundException {
        Channel channel = channelService.findOneChannel("UC4pNDofN0Xh-z2bhh62g8Ow");
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel);
    }
    @Test
    void findOneChannel2() {
        Channel channel = channelService.findOneChannel2("UC4pNDofN0Xh-z2bhh62g8Ow",10,10);
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel);
    }

    @Test
    void findOneChannel3() throws CommentException, NotFoundException {
        Channel channel = channelService.findOneChannel3("UC4pNDofN0Xh-z2bhh62g8Ow",10,10);
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel);
    }


}
