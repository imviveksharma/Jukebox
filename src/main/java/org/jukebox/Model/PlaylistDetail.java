package org.jukebox.Model;

public class PlaylistDetail {
    private String playlisid;
    private String songsid;
    private String podcasid;

    public PlaylistDetail(String playlisid, String songsid, String podcasid) {
        this.playlisid = playlisid;
        this.songsid = songsid;
        this.podcasid = podcasid;
    }

    public String getPlaylisid() {
        return playlisid;
    }

    public void setPlaylisid(String playlisid) {
        this.playlisid = playlisid;
    }

    public String getSongsid() {
        return songsid;
    }

    public void setSongsid(String songsid) {
        this.songsid = songsid;
    }

    public String getPodcasid() {
        return podcasid;
    }

    public void setPodcasid(String podcasid) {
        this.podcasid = podcasid;
    }

    @Override
    public String toString() {
        return "PlaylistDetail{" +
                "playlisid='" + playlisid + '\'' +
                ", songsid='" + songsid + '\'' +
                ", podcasid='" + podcasid + '\'' +
                '}';
    }
}
