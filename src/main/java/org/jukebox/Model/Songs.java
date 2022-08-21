package org.jukebox.Model;

public class Songs {
    private String songid;
    private String songname;
    private String duration;
    private String artistname;
    private String genre;
    private String filepath;

    public Songs(String songid, String songname, String duration, String artistname, String genre, String filepath) {
        this.songid = songid;
        this.songname = songname;
        this.duration = duration;
        this.artistname = artistname;
        this.genre = genre;
        this.filepath = filepath;
    }


    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return (String.format("%16s %25s %25s %20s %20s ",songid,songname,duration,artistname,genre));
    }
}
