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
    @Autowired
    CaptionService captionService;
    @Autowired
    CommentService commentService;

    @Autowired
    ChannelService channelService;

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

    public List<VideoSnippet> findAllVideos(String id_channel, Integer maxVideos, Integer maxComments){
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token +"&part=snippet&channelId=" + id_channel + "&type=video";
        List<VideoSnippet> videos = null;
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,VideoSnippetSearch.class);
        videos = response.getBody().getItems().stream().limit(maxVideos).toList();
        //videos.stream().forEach(v -> v.setCaptions(captionService.findAllCaptions(id_channel, v.getId().toString())));
        videos.stream().forEach(v -> v.setComments(commentService.findAll(id_channel, v.getId().toString()).stream().limit(maxComments).toList()));
        return videos;
    }
    public VideoSnippet findOne1(String id_channel, String id_video){
        VideoSnippet res = null;
        Channel channel = channelService.findOne1(id_channel,10,10);
        for(VideoSnippet video: channel.getVideos()){
            if(video.getId().equals(id_video)){
                res = video;
            }
        }
        return res;
    }

    public VideoSnippet findOne(String id_channel, String id_video) {
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token +"&part=snippet&channelId=" + id_channel + "&type=video";
        List<VideoSnippet> videos = null;
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange
                (uri, HttpMethod.GET,request,VideoSnippetSearch.class);
        videos = response.getBody().getItems();
        VideoSnippet video = null;
        if(videos != null){
            for(VideoSnippet v:videos) {
                if (v.getId().equals(id_video)) {
                    video = v;
                }
            }
        }
        return video;
    }

    /*
    public VideoSnippetDetails findOne(String id_channel, String id_video) {
        List<VideoSnippet> videos = findAllVideos(id_channel);
        for (VideoSnippet v : videos) {
            if (v.getId().getVideoId().equals(id_video)) {
                return v.getSnippet();
            }
        }
        return null;
    }
    */

}
