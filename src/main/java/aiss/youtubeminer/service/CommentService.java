package aiss.youtubeminer.service;

import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.comment.CommentSearch;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    VideoService videoService;


    /*
    @Autowired
    VideoService videoService;
    */

    /*
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

     */


    public List<Comment> findAll(String channelId, String videoId){
        VideoSnippet video = videoService.findOne1(channelId, videoId);
        List<Comment> comments = video.getComments();
        return comments;
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
