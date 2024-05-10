package aiss.youtubeminer.service;

import aiss.youtubeminer.exceptions.CommentException;
import aiss.youtubeminer.exceptions.NotFoundException;
import aiss.youtubeminer.model.caption.Caption;
import aiss.youtubeminer.model.channel.ChannelSearch;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.transformer.ChannelTrans;
import aiss.youtubeminer.transformer.ChannelTransformer;
import aiss.youtubeminer.transformer.VideoTrans;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.youtubeminer.model.channel.Channel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    VideoService videoService;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;



    public Channel findOneChannel2(String id, Integer maxVideos, Integer maxComments){
        List<Channel> channels = null;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
                + id +"&key=" + token + "&part=snippet";
        ChannelSearch channelSearch = restTemplate.getForObject(uri, ChannelSearch.class);
        channels = channelSearch.getItems();
        Channel res = channels.get(0);
        res.setVideos(res.getVideos().stream().limit(maxVideos).toList());
        for(VideoSnippet v: res.getVideos()){
            v.setComments(v.getComments().stream().limit(maxComments).toList());
        }
        return res;
    }


    public Channel findOneChannel3(String id, Integer maxVideos, Integer maxComments)
                    throws NotFoundException, CommentException {

                Channel channel = null;
                try {
                    channel = findOneChannel(id);
                }catch (Exception e){

                    throw new NotFoundException();

                }
                List<VideoSnippet> videos = videoService.findAllVideos(id).stream().limit(maxVideos).toList();
                for (VideoSnippet v : videos) {
                    try {
                        v.setComments(commentService.findAllComments(id, v.getId().getVideoId(), maxComments));
                    }catch (Exception e){
                        v.setComments(new ArrayList<>());
                     }
                    v.setCaptions(captionService.findAllCaptions(id, v.getId().getVideoId()));
                }
                channel.setVideos(videos);
                return channel;

    }

    public Channel findOneChannel(String id) throws NotFoundException {
        List<Channel> channels = null;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?id="
                + id +"&key=" + token + "&part=snippet";
        try {
            ChannelSearch channelSearch = restTemplate.getForObject(uri, ChannelSearch.class);
            channels = channelSearch.getItems();
            return channels.get(0);
        }catch (Exception e){
            throw new NotFoundException();
        }


    }


}
