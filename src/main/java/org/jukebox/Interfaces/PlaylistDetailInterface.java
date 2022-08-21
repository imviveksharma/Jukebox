package org.jukebox.Interfaces;

import org.jukebox.Model.Playlist;

import java.util.List;

public interface PlaylistDetailInterface {
    List<Playlist> viewAllplaylist();
    void add_songs();
    void showandplayPlaylist();
    void readPlaylist(String audioSrcFile, int count);
}
