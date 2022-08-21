package org.jukebox.Model;

public class Podcast {
    private String podcastid;
    private String podcastname;
    private int episodes;
    private String filepath;

    public Podcast(String podcastid, String podcastname, int episodes, String filepath) {
        this.podcastid = podcastid;
        this.podcastname = podcastname;
        this.episodes = episodes;
        this.filepath = filepath;
    }

    public Podcast() {
    }

    public String getPodcastid() {
        return podcastid;
    }

    public void setPodcastid(String podcastid) {
        this.podcastid = podcastid;
    }

    public String getPodcastname() {
        return podcastname;
    }

    public void setPodcastname(String podcastname) {
        this.podcastname = podcastname;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return (String.format("%16s %25s %25s ",podcastid,podcastname,episodes));
    }
}