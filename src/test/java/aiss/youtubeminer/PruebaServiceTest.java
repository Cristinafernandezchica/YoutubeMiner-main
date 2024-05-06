package aiss.youtubeminer;

import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.service.PruebaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PruebaServiceTest {
    @Autowired
    PruebaService pruebaService;

    @Test
    void findOne() {
        Channel channel = pruebaService.findOneChannel("UC4pNDofN0Xh-z2bhh62g8Ow");
        assertFalse(channel == null,"No se ha encontrado el canal");
        System.out.println(channel.getId());
    }

}
