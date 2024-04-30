package aiss.youtubeminer.service;

import java.util.List;

import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetDetails;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetSearch;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    /*
    public List<VideoSnippet> findAllVideos(String id_channel){
        List<VideoSnippet> videos = null;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token +"&part=snippet&channelId=" + id_channel + "&type=video";
        VideoSnippetSearch videoSnippetSearch = restTemplate.getForObject(uri, VideoSnippetSearch.class);
        videos = videoSnippetSearch.getItems();
        return videos;
    }
    */

    public List<VideoSnippet> findAllVideos(String id_channel){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token +"&part=snippet&channelId=" + id_channel + "&type=video";
        List<VideoSnippet> videos = null;
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,VideoSnippetSearch.class);
        videos = response.getBody().getItems();
        return videos;
    }


    public VideoSnippetDetails findOne(String id_channel, String id_video) {
        List<VideoSnippet> videos = findAllVideos(id_channel);
        for (VideoSnippet v : videos) {
            if (v.getId().getVideoId().equals(id_video)) {
                return v.getSnippet();
            }
        }
        return null;
    }






}
