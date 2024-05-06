package aiss.youtubeminer.service;

import aiss.youtubeminer.model.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.youtubeminer.model.channel.Channel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;


    public Channel findOneChannel(String id){
        List<Channel> channels = null;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
                + id +"&key=" + token + "&part=snippet";
        ChannelSearch channelSearch = restTemplate.getForObject(uri, ChannelSearch.class);
        channels = channelSearch.getItems();
        return channels.get(0);
    }


}
