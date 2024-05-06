package aiss.youtubeminer.service;

import aiss.youtubeminer.model.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PruebaService {
    @Autowired
    RestTemplate restTemplate;

    public Channel findOneChannel(String id){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
                + id +"&key=" + token + "&part=snippet";
        //HttpHeaders headers = new HttpHeaders();
        HttpEntity<Channel> request = new HttpEntity<>(null);
        ResponseEntity<Channel> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Channel.class);
        Channel channel = null;
        channel = response.getBody();
        return channel;
    }
}
