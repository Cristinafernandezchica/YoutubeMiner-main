package aiss.youtubeminer.service;

import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.channel.ChannelSearch;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    //@Autowired
    //VideoService videoService;

    public Channel findOne2(String id){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token
                +"&part=snippet&id="+id;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Channel> request = new HttpEntity<>(null);
        ResponseEntity<Channel> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Channel.class);
        Channel channel = null;
        channel = response.getBody();

        //Channel channel1 = restTemplate.getForObject(uri,Channel.class);

        return channel;
    }


    public Channel findOne1(String id, Integer maxVideos, Integer maxComments){
        List<Channel> channels = null;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
                + id +"&key=" + token + "&part=snippet";
        ChannelSearch channelSearch = restTemplate.getForObject(uri, ChannelSearch.class);
        channels = channelSearch.getItems();
        Channel res = channels.get(0);
        res.setVideos(res.getVideos().stream().limit(maxVideos).toList());
        for(VideoSnippet video:res.getVideos()){
            video.setComments(video.getComments().stream().limit(maxComments).toList());
        }
        return channels.get(0);
    }
    /*

    public Channel findOne1(String id){
        Channel channel = null;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?key="
                + token +"&id=" + id + "&part=snippet";
        //HttpHeaders headers = new HttpHeaders();
        HttpEntity<Channel> request = new HttpEntity<>(null, null);
        ResponseEntity<Channel> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Channel.class);
        channel = response.getBody();
        return channel;
    }

    public Channel findOne(String id, Integer maxVideos, Integer maxComments){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
                + id +"&key=" + token + "&part=snippet";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Channel> request = new HttpEntity<>(null,headers);
        ResponseEntity<Channel> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,Channel.class);
        Channel channel = null;
        channel = response.getBody();
        //channel.setVideos(VideoService.findAllVideos(channel.getId(), maxVideos, maxComments));

        return channel;
    }



    /*
    public Channel createChannel(Channel channel){
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token
                +"&part=snippet&channelId="+channel.getId();

        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";

        HttpEntity<Channel> request = new HttpEntity<>(channel);
        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.POST, request, Channel.class);
        Channel createdChannel = response.getBody();
        return createdChannel;
    }
    */


}
