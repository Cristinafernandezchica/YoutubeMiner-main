package aiss.youtubeminer.transformer;


import com.fasterxml.jackson.annotation.JsonProperty;


public class CaptionTrans {
    @JsonProperty("id")
    private String id;

    // modificado
    @JsonProperty("name")
    private String name;

    // modificado
    @JsonProperty("language")
    private String language;

    public CaptionTrans(String id, String name, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
