package aiss.youtubeminer.service;

import aiss.youtubeminer.model.caption.Caption;
import aiss.youtubeminer.model.caption.CaptionSearch;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {

    @Autowired
    RestTemplate restTemplate;

    String token = "AIzaSyDOQqDqyCRvWwCmHqciyqrg8PtVywgNKlI";

    public List<Caption> findAllCaptions(String id_video){
        List<Caption> captions = null;
        String uri = "https://www.googleapis.com/youtube/v3/captions?part=snippet&videoId="+id_video+"&key="+token;
        CaptionSearch captionSearch = restTemplate.getForObject(uri, CaptionSearch.class);
        captions = captionSearch.getItems();
        return captions;
    }

}
