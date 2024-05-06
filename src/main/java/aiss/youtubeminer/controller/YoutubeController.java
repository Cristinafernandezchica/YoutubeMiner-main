package aiss.youtubeminer.controller;

import aiss.youtubeminer.transformer.ChannelTrans;
import aiss.youtubeminer.transformer.VideoTrans;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import aiss.youtubeminer.service.ChannelService;
import aiss.youtubeminer.transformer.ChannelTransformer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import aiss.youtubeminer.model.channel.Channel;

@RestController
@RequestMapping("/youtube/channels")
public class YoutubeController {
    @Autowired
    ChannelService channelService;
    @Autowired
    RestTemplate restTemplate;

    ChannelTransformer channelTransformer = new ChannelTransformer();
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelTrans findOne(@PathVariable String id,
                              @RequestParam(required = false, defaultValue = "10") Integer maxVideos,
                              @RequestParam(required = false, defaultValue = "10") Integer maxComments) {
        //Channel newChannel = channelService.findOne1(id, maxVideos, maxComments);
        Channel newChannel = channelService.findOne1(id, maxVideos, maxComments);
        ChannelTrans videoChannel = channelTransformer.transform(newChannel);
        String uri = "http://localhost:8080/videominer/channels";
        HttpEntity<ChannelTrans> request = new HttpEntity<>(videoChannel);
        ResponseEntity<ChannelTrans> responseEx =
                restTemplate.exchange(uri, HttpMethod.POST, request, ChannelTrans.class);
        ChannelTrans createdChannel = responseEx.getBody();
        return createdChannel;
    }

}
