package csc319.j4module.class1demo.video;

public class Video {
    private String name;
    private String url;
    private int duration;

    public Video(String name, String url, int duration) {
        super();
        this.name = name;
        this.url = url;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public long getDuration() {
        return duration;
    }
}
