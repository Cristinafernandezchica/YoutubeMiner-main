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

    //@Test
    //void findOne() {
      //  Channel channel = channelService.findOne("UC4pNDofN0Xh-z2bhh62g8Ow", 10, 10);
        //assertFalse(channel == null,"No se ha encontrado el canal");
        //System.out.println(channel.getId());
    //}

    @Test
    void findOne1() {
        Channel channel = channelService.findOne1("UC4pNDofN0Xh-z2bhh62g8Ow",10,10);
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel.getId());
    }

    @Test
    void findOne2() {
        Channel channel = channelService.findOne2("UC4pNDofN0Xh-z2bhh62g8Ow");
        //assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel.getId());
    }

}
