package org.jukebox;

import org.jukebox.ImplClass.SongsImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongsImplTest {
    SongsImpl songsimplObj=null;

    @BeforeEach
    public void setUp()
    {
      songsimplObj=new SongsImpl();
    }
    @AfterEach
    public void tearDown()
    {
        songsimplObj=null;
    }
    @Test
    public void displayAllSongs_test()
    {
        assertEquals(9,songsimplObj.displayAllSongs().size());
    }
   /* @Test
    public void sortSong_test()
    {
        assertEquals(true,songsimplObj.sortAllSongs().);
    }*/
}
