package org.jukebox;

import org.jukebox.ImplClass.SongsImpl;
import org.jukebox.ImplClass.UserImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserImplTest {
    UserImpl userimplobj=null;
    @BeforeEach
    public void setUp()
    {
        userimplobj=new UserImpl();
    }
    @AfterEach
    public void tearDown()
    {
        userimplobj=null;
    }
   /* @Test
    public void createid_test()
    {

    }*/
}
