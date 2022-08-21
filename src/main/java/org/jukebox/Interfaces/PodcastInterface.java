package org.jukebox.Interfaces;

import org.jukebox.Model.Podcast;
import org.jukebox.Model.Songs;

import java.util.List;

public interface PodcastInterface {
    List<Podcast> displayAllPodcast();
    List <Podcast> sortAllPodcast();
    List <Podcast> searchPodcast(String pid);
    String getpodcastId();
}
