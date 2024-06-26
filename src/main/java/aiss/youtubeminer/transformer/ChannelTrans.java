package aiss.youtubeminer.transformer;

import aiss.youtubeminer.model.videoSnippet.VideoSnippet;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ChannelTrans {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("createdTime")
    private String createdTime;

    @JsonProperty("videos")
    private List<VideoTrans> videos;

    public ChannelTrans() {
        this.videos = new ArrayList<>();
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<VideoTrans> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoTrans> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", videos=" + videos +
                '}';
    }
}
