package org.jukebox;

import org.jukebox.ImplClass.PodcastImpl;
import org.jukebox.ImplClass.SongsImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PodcastImplTest {
    PodcastImpl podcastimplObj=null;

    @BeforeEach
    public void setUp()
    {
        podcastimplObj=new PodcastImpl();
    }
    @AfterEach
    public void tearDown()
    {
        podcastimplObj=null;
    }
    @Test
    public void displayAllPodcast_test()
    {
        assertEquals(6,podcastimplObj.displayAllPodcast().size());
    }
}
