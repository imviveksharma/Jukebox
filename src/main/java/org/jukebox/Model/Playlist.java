package org.jukebox.Model;

public class Playlist {
    private String playlistid;
    private String username;
    private String playlistname;

    public Playlist(String playlistid, String username, String playlistname) {
        this.playlistid = playlistid;
        this.username = username;
        this.playlistname = playlistname;
    }

    public Playlist() {

    }

    public String getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(String playlistid) {
        this.playlistid = playlistid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    @Override
    public String toString() {
        return (String.format("%16s %25s ",playlistid,playlistname));
    }
}
