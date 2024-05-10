package aiss.youtubeminer.service;

import aiss.youtubeminer.exceptions.CommentException;
import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.channel.ChannelSearch;
import aiss.youtubeminer.model.channel.ChannelSnippet;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;


    public List<VideoSnippet> findAllVideos(String id) throws CommentException{
            List<VideoSnippet> videos = null;
            String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
                String uri = "https://www.googleapis.com/youtube/v3/search?key=" + token + "&part=snippet&channelId=" + id + "&type=video";
            VideoSnippetSearch videoSnippetSearch = restTemplate.getForObject(uri, VideoSnippetSearch.class);
            videos = videoSnippetSearch.getItems();
            return videos;

    }





}
