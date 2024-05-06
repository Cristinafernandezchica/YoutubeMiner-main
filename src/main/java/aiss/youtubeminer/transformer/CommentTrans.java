package aiss.youtubeminer.transformer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentTrans {
    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private String text;

    @JsonProperty("createdOn")
    private String createdOn;

    @JsonProperty("author")
    private UserTrans author;

    public CommentTrans(String id, String text, String createdOn, UserTrans author){

        this.id = id;
        this.text = text;
        this.createdOn = createdOn;
        this.author = author;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public UserTrans getAuthor() {
        return author;
    }

    public void setAuthor(UserTrans author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", author=" + author +
                '}';
    }
}
