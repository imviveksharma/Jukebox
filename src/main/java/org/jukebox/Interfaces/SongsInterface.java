package org.jukebox.Interfaces;

import org.jukebox.Model.Songs;

import java.util.List;

public interface SongsInterface {
    List<Songs> displayAllSongs();
    List <Songs> sortAllSongs();
    List<Songs> searchSong(String sid);
    String getsongId();
    void readAudio(String audioSrcFile, int count);


}
