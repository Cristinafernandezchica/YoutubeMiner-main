package aiss.youtubeminer.service;

import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.comment.CommentSearch;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import java.util.List;

public class CommentService {

    @Autowired
    RestTemplate restTemplate;

     public List<Comment> findAll(String channelId, String videoId){
         // Se deberia de hacer llamada al video a traves de estos datos
         // y despues acceder a commentThread
        List<Comment> comments;
        String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
        String uri = "https://youtube.googleapis.com/youtube/v3/commentThreads?key="
            + token + "&videoId=" + "&part=snippet";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<CommentSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<CommentSearch> response = restTemplate.exchange
            (uri, HttpMethod.GET,request,CommentSearch.class);
        CommentSearch commentSearch = response.getBody();
        comments = commentSearch.getItems();

        return comments;
     }

    public List<Comment> findAll2(String channelId, String videoId){
        // Se deberia de hacer llamada al video a traves de estos datos
        // y despues acceder a commentThread
        List<Comment> comments;
        VideoSnippetDetails video = VideoService.findOne(channelId, videoId).;

        return VideoService.findOne(channelId, videoId).;
    }

    /*
    Comment comment = null;
    headers.set("Authorization","Bearer " + token);
    HttpEntity<Channel> request = new HttpEntity<>(null,headers);
    ResponseEntity<Channel> response = restTemplate.exchange
            (uri, HttpMethod.GET,request,Channel.class);
    channel = response.getBody();


        return channel;
*/

}
