package org.jukebox.ImplClass;

import org.jukebox.DBConnection;
import org.jukebox.Interfaces.PlaylistDetailInterface;
import org.jukebox.Model.PlayAudio;
import org.jukebox.Model.Playlist;
import org.jukebox.Model.Songs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistDetailImpl implements PlaylistDetailInterface {
    Connection con = DBConnection.getConnection();
    Scanner sc=new Scanner(System.in);

    @Override
    public List<Playlist> viewAllplaylist() {
        List<Playlist> playlistL = null;
        try {
            System.out.println("Enter Username Again for Verification");
            String uname=sc.nextLine();
            String Query = "select * from playlist where username=?";
            PreparedStatement ps= con.prepareStatement(Query);
            ps.setString(1,uname);
            playlistL = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Playlist pl = new Playlist(rs.getString("playlistid"),rs.getString("username"), rs.getString("playlistname"));
                playlistL.add(pl);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return playlistL;
    }

    @Override
    public void add_songs() {
       try {
           String id = null;
           String choose = null;
           System.out.println("Enter Playlist Id");
           String pid = sc.nextLine();
           System.out.println("Choose What You Want To Insert\n1.Song\n2.Podcast");
           int choice = sc.nextInt();
           switch(choice){
               case 1:
                   sc.nextLine();
                   System.out.println("Enter Song Id which You want to insert in playlist");
                      id = sc.nextLine();
                   String query = "insert into playlistdetail(playlistid,songid) values(?,?)";
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.setString(1,pid);
                   ps.setString(2,id);
                   ps.executeUpdate();
                   System.out.println("Inserted Successfully"); break;

               case 2:
                   sc.nextLine();
               System.out.println("Enter Podcast Id which You want to insert in playlist");
                id = sc.nextLine();
                   String query1 = "insert into playlistdetail(playlistid,podcastid) values(?,?)";
                   PreparedStatement pst = con.prepareStatement(query1);
                   pst.setString(1,pid);
                   pst.setString(2,id);
                   pst.executeUpdate();
                   System.out.println("Inserted Successfully");break;

           }

       }catch(Exception e){
           System.out.println(e);
       }

    }

    @Override
    public void showandplayPlaylist() {
       try {
           System.out.println("Enter Playlist id to play");
           String pid = sc.nextLine();
           String query = "select song.songname,song.filepath from playlistdetail join song on playlistdetail.songid=song.songid where playlistid=?";
           //String query="select s.songname,s.filepath,po.podcastname,po.filepat from song s join playlistdetail p on s.songid=p.songid left join podcast po on po.podcastid=p.podcastid where playlistid=?";
           PreparedStatement st = con.prepareStatement(query);
           st.setString(1, pid);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               System.out.println("Song Name-"+rs.getString("songname"));
              // System.out.println("Podcast Name-"+rs.getString("podcastname"));
               String audio=(rs.getString("filepath"));
             //  String audio1=(rs.getString("filepat"));
               readPlaylist(audio,1);//readPlaylist(audio1,1);
           }
       }catch(Exception e){
           System.out.println(e);
       }
    }
       @Override
    public void readPlaylist(String audioSrcFile, int count) {
        PlayAudio playAudio = new PlayAudio();
        int c = 0;
        count = count-1;
        try {

            playAudio.playAudio1(audioSrcFile,count);

            playAudio.play();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. next");
                System.out.println("5. exit");

                if (c == 4) {
                    break;
                }

                if (scanner.hasNextInt()) {
                    c = scanner.nextInt();
                } else {
                    break;
                }
                switch (c) {
                    case 1:
                        playAudio.pause();
                        break;
                    case 2:
                        playAudio.resumeAudio();
                        break;
                    case 3:
                        playAudio.restart();
                        break;
                    case 4:
                        playAudio.stop();
                        break;
                    case 5: System.exit(0);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }

}
