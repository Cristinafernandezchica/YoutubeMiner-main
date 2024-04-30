package aiss.youtubeminer.service;

import java.util.List;
import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.channel.ChannelSearch;
import com.sun.net.httpserver.HttpsParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;
/**
    public Channel findOne(String id){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token
                +"&part=snippet&id="+id;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Channel> request = new HttpEntity<>(null,headers);
        ResponseEntity<Channel> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Channel.class);
        Channel channel = null;
        channel = response.getBody();

        Channel channel1 = restTemplate.getForObject(uri,Channel.class);

        return channel;
    }
**/

/*
public Channel findOne(String id){
    List<Channel> channels = null;
    String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
    String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
            + id +"&key=" + token + "&part=snippet";
    ChannelSearch channelSearch = restTemplate.getForObject(uri, ChannelSearch.class);
    channels = channelSearch.getItems();
    return channels.get(0);
}
*/


public Channel findOne(String id){
    String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
    String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
            + id +"&key=" + token + "&part=snippet";
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<Channel> request = new HttpEntity<>(null,headers);
    ResponseEntity<Channel> response = restTemplate.exchange
            (uri, HttpMethod.GET,request,Channel.class);
    Channel channel = null;
    channel = response.getBody();

    return channel;
}



    /**
    public Channel createChannel(Channel channel){
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token
                +"&part=snippet&channelId="+channel.getId();

        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";

        HttpEntity<Channel> request = new HttpEntity<>(channel);
        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.POST, request, Channel.class);
        Channel createdChannel = response.getBody();
        return createdChannel;
    }
**/
}
