package aiss.youtubeminer.service;

import aiss.youtubeminer.model.caption.Caption;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.comment.CommentSearch;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class CaptionService {

    @Autowired
    RestTemplate restTemplate;
    VideoService videoService;

    /*
    public List<Caption> findAllCaptions(String id_channel, String id_video){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token +"&part=snippet&channelId=" + id_channel + "&type=video";
        List<VideoSnippet> videos = null;
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,VideoSnippetSearch.class);
        videos = response.getBody().getItems();
        return videos;
    }
     */
    public List<Caption> findAllCaptions(String channelId, String videoId){
        VideoSnippet video = videoService.findOne(channelId, videoId);
        List<Caption> captions = null;
        captions = video.getCaptions();
        return captions;
    }


}
