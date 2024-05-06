package aiss.youtubeminer.service;

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
    void findOneChannel() {
        Channel channel = channelService.findOneChannel("UC4pNDofN0Xh-z2bhh62g8Ow");
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel);
    }


}
