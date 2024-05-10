package aiss.youtubeminer.service;

import aiss.youtubeminer.exceptions.CommentException;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.comment.CommentSearch;
import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import aiss.youtubeminer.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;


    public List<Comment> findAllComments(String id_channel, String id_video, Integer maxComments)
                    throws  CommentException{
        try {
            List<Comment> comments = null;
            String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";
            String uri = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=" + id_video + "&maxResults=" + maxComments + "&key=" + token;
            CommentSearch commentSearch = restTemplate.getForObject(uri, CommentSearch.class);
            comments = commentSearch.getItems();
            return comments;
        }catch(Exception e){
            throw new CommentException();
        }
    }




}
