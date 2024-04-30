package aiss.youtubeminer.service;

import java.util.List;
import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.channel.ChannelSearch;
import com.sun.net.httpserver.HttpsParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;


}
