package org.jukebox;

import org.jukebox.ImplClass.*;
import org.jukebox.Model.Playlist;
import org.jukebox.Model.PlaylistDetail;
import org.jukebox.Model.Podcast;
import org.jukebox.Model.Songs;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws UnsupportedAudioFileException, IOException, LineUnavailableException,SQLException {

        Scanner sc=new Scanner(System.in);
       while(true)
       {
           System.out.println("--------------------------------------------------------------------------");
           System.out.println("|<<<<<<<<<<<<<<<<<<<<<<<<<< WELCOME TO JUKEBOX >>>>>>>>>>>>>>>>>>>>>>>>>>|");
           System.out.println("--------------------------------------------------------------------------");
           System.out.println("1.New User\n2.Registered User\n3.Exit");
           System.out.println("Enter Choice:");
           int ch=sc.nextInt();
           switch(ch)
           {
               case 1:
                   UserImpl ui=new UserImpl();
                   ui.create_id();
                   break;
               case 2:UserImpl ui1=new UserImpl();ui1.login();
                  while(true){ System.out.println("Enter Choices\n1.Enter into Songs\n2.Enter Into Podcast\n3.Enter Into Playlist\n4.Update Id\n5.Menu\n6.Exit");
                   int choices=sc.nextInt();
                   switch(choices){
                       case 1:
                          System.out.println("1.Display All Songs\n2.Sort Song\n3.Search Song\n4.Play Song\n5.Back");
                           int schoice=sc.nextInt();
                           switch(schoice){
                               case 1:
                                   List<Songs> songdetail=new SongsImpl().displayAllSongs();
                                   System.out.println(String.format("%16s %25s %25s %20s %20s ","SongId","Song Name","Duration","Artist Name","Genre"));
                                   songdetail.stream().forEach(x-> System.out.println(x));continue;
                               case 2:
                                   List<Songs> sortsongs=new SongsImpl().sortAllSongs();
                                   System.out.println(String.format("%16s %25s %25s %20s %20s ","SongId","Song Name","Duration","Artist Name","Genre"));
                                   sortsongs.stream().forEach(e-> System.out.println(e));continue;
                               case 3:
                                   sc.nextLine();
                                   System.out.println("Enter Song Id");
                                   String sid=sc.nextLine();
                                   List<Songs> search=new SongsImpl().searchSong(sid);
                                   System.out.println(String.format("%16s %25s %25s %20s %20s ","SongId","Song Name","Duration","Artist Name","Genre"));
                                   search.stream().forEach(c-> System.out.println(c));continue;
                               case 4:String audio=new SongsImpl().getsongId();
                                   new SongsImpl().readAudio(audio,1);
                                      continue;
                               case 5:break;
                            }break;
                       case 2:
                           System.out.println("1.Display All Podcast\n2.Sort Podcast\n3.Search Podcast\n4.Play Podcast\n5.Back");
                           int schoice1=sc.nextInt();
                           switch(schoice1){
                               case 1: List<Podcast> podcastdetail=new PodcastImpl().displayAllPodcast();
                                   System.out.println(String.format("%16s %25s %25s ","Podcast Id","Podcast Name","Episodes"));
                               podcastdetail.stream().forEach(x-> System.out.println(x));continue;
                               case 2: List<Podcast> sortpodcast=new PodcastImpl().sortAllPodcast();
                                   System.out.println(String.format("%16s %25s %25s ","Podcast Id","Podcast Name","Episodes"));
                               sortpodcast.stream().forEach(e-> System.out.println(e));continue;
                               case 3: sc.nextLine();
                                   System.out.println("Enter Podcast Id");
                                   String pid=sc.nextLine();
                                   List<Podcast> search=new PodcastImpl().searchPodcast(pid);
                                   System.out.println(String.format("%16s %25s %25s ","Podcast Id","Podcast Name","Episodes"));
                                   search.stream().forEach(x-> System.out.println(x));continue;
                               case 4:String audio=new PodcastImpl().getpodcastId();
                                   new SongsImpl().readAudio(audio,1);
                                   continue;
                               case 5:break;
                               default:
                                   System.out.println("Invalid Choice");continue;
                           }break;
                       case 3:sc.nextLine();
                           System.out.println("1.Create Playlist\n2.Delete Playlist\n3.Show Playlist\n4.Add songs In Playlist\n5.Play Playlist\n6.Back");
                           int choice2=sc.nextInt();PlaylistImpl pim=new PlaylistImpl();PlaylistDetailImpl pimd=new PlaylistDetailImpl();
                           switch(choice2){
                               case 1: pim.create_playlist();continue;
                               case 2: pim.delete_playlist();continue;
                               case 3: List<Playlist> aplaylist =new PlaylistDetailImpl().viewAllplaylist();
                                   System.out.println(String.format("%16s %25s ","Playlist Id","Playlist Name"));
                               aplaylist.stream().forEach(x-> System.out.println(x));continue;
                               case 4: pimd.add_songs();continue;
                               case 5: pimd.showandplayPlaylist();continue;
                               case 6: break;
                               default:
                                   System.out.println("Invalid Choice");continue;
                           }break;
                       case 4:UserImpl ui2=new UserImpl();ui2.update_id();break;
                       case 5:continue;
                       case 6:System.exit(0);
                   }
                  }

               case 3:System.exit(0);
                   break;
               default:
                   System.out.println("Invalid Choice!!");
           }
       }
    }
}
