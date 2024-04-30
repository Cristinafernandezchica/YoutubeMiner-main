package aiss.youtubeminer;

import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.service.ChannelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void findOne() {
        Channel channel = channelService.findOne("UC4pNDofN0Xh-z2bhh62g8Ow");
        assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel.getId());
    }
    // prueba despues el findOne2




}
