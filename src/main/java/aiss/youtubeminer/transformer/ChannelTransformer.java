package aiss.youtubeminer.transformer;

import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import aiss.youtubeminer.model.channel.Channel;
import aiss.youtubeminer.model.comment.Comment;
import aiss.youtubeminer.model.caption.Caption;

import java.util.ArrayList;
import java.util.List;

public class ChannelTransformer {
    @Autowired
    RestTemplate restTemplate;

    public ChannelTrans transform(Channel channel){

        List<VideoTrans> listaVideos = new ArrayList<>();
        listaVideos = transformVideos(channel.getVideos());
        ChannelTrans videoChannel = new ChannelTrans();
        videoChannel.setId(channel.getId());
        videoChannel.setVideos(listaVideos);
        videoChannel.setName(channel.getSnippet().getTitle());
        videoChannel.setDescription(channel.getSnippet().getDescription());
        videoChannel.setCreatedTime(channel.getSnippet().getPublishedAt());

        return videoChannel;
    }

    public ChannelTransformer(){
    }

    private List<VideoTrans> transformVideos(List<VideoSnippet> videos){
        List<VideoTrans> list = new ArrayList<>();
        for (VideoSnippet v: videos){
            List<CommentTrans> comments = transformComments(v.getComments());
            List<CaptionTrans> captions = transformCaptions(v.getCaptions());
            VideoTrans newVideo = new VideoTrans(
                    v.getId().getVideoId(),
                    v.getSnippet().getTitle(),
                    v.getSnippet().getDescription(),
                    v.getSnippet().getPublishedAt(),
                    comments,
                    captions
            );

            list.add(newVideo);
        }
        return list;
    }

    private List<CaptionTrans> transformCaptions(List<Caption> captions){
        List<CaptionTrans> res = new ArrayList<>();
        for(Caption caption: captions){
            CaptionTrans newCaption = new CaptionTrans(
                    caption.getId(),
                    caption.getName(),
                    caption.getLanguage()
            );
            res.add(newCaption);
        }
        return res;
    }


    private List<CommentTrans> transformComments(List<Comment> comments){
        List<CommentTrans> res = new ArrayList<>();
        for (Comment comment: comments){
            UserTrans user = transformUser(comment);
            CommentTrans newComment = new CommentTrans(
                    comment.getCommentSnippet().getTopLevelComment().getId(),
                    comment.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal(),
                    comment.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt(),
                    user
            );
            res.add(newComment);
        }
        return res;
    }

    private UserTrans transformUser(Comment comment) {
        UserTrans res = new UserTrans(
                comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName(),
                comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelUrl(),
                comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorProfileImageUrl()
        );

        return  res;

    }

}
