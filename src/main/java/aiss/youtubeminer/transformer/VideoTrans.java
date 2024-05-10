package aiss.youtubeminer.transformer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class VideoTrans {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("releaseTime")
    private String releaseTime;

    @JsonProperty("comments")
    private List<CommentTrans> comments;

    @JsonProperty("captions")
    private List<CaptionTrans> captions;

    public VideoTrans(String Pid, String title, String pDescription,
                           String pReleaseTime, List<CommentTrans> pComments, List<CaptionTrans> pCaptions){

        this.id = Pid;
        this.name = title;
        this.description = pDescription;
        this.releaseTime = pReleaseTime;
        this.comments = pComments;
        this.captions = pCaptions;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<CommentTrans> getComments() {
        return comments;
    }

    public void setComments(List<CommentTrans> comments) {
        this.comments = comments;
    }

    public List<CaptionTrans> getCaptions() {
        return captions;
    }

    public void setCaptions(List<CaptionTrans> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", comments=" + comments +
                ", captions=" + captions +
                '}';
    }
}
