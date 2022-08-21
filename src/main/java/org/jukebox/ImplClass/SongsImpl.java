package org.jukebox.ImplClass;

import org.jukebox.DBConnection;
import org.jukebox.Interfaces.SongsInterface;
import org.jukebox.Model.PlayAudio;
import org.jukebox.Model.Songs;
import java.lang.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongsImpl implements SongsInterface {
    Connection con = DBConnection.getConnection();
    Scanner sc=new Scanner(System.in);

    @Override
    public List<Songs> displayAllSongs() {

        List<Songs> songsList = null;
        try {
            Statement st = con.createStatement();
            String Query = "select * from song";
            songsList = new ArrayList<>();
            ResultSet rs = st.executeQuery(Query);
            while (rs.next()) {
                Songs songs = new Songs(rs.getString("songid"), rs.getString("songname"), rs.getString("duration"), rs.getString("artistname"), rs.getString("genre"), rs.getString("filepath"));
                songsList.add(songs);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return songsList;
    }


    @Override
    public List<Songs> sortAllSongs() {
     List<Songs> sortsong=null;
     try{
         Statement st= con.createStatement();
         String Query1=null;
         System.out.println("Sort Based On\n1.Song Name\n2.Artist Name\n3.Genre");
         int choice=sc.nextInt();
         switch(choice){
             case 1: Query1="select * from song order by songname"; break;
             case 2: Query1="select * from song order by artistname"; break;
             case 3: Query1="select * from song order by genre";break;
             default:
                 System.out.println("Invalid Choice");break;
         }
         sortsong=new ArrayList<>();
         ResultSet rs= st.executeQuery(Query1);
         while(rs.next()){
             Songs sort=new Songs(rs.getString("songid"), rs.getString("songname"), rs.getString("duration"), rs.getString("artistname"), rs.getString("genre"), rs.getString("filepath"));
             sortsong.add(sort);
         }
     }catch(Exception ex){
         System.out.println(ex);
     }
     return sortsong;
    }



    @Override
    public List<Songs> searchSong(String sid) {

        List<Songs> search = null;
        try {
            String Query2 = "select * from song where songid=?";
            PreparedStatement p = con.prepareStatement(Query2);
            p.setString(1,sid);
            search = new ArrayList<>();
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Songs slist = new Songs(rs.getString("songid"), rs.getString("songname"), rs.getString("duration"), rs.getString("artistname"), rs.getString("genre"), rs.getString("filepath"));
                search.add(slist);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return search;
    }

    @Override
    public String getsongId() {
        String audio=null;
       try{ System.out.println("Enter Song Id");
        String sid=sc.nextLine();
        String query= "select filepath from song where songid=?";
       PreparedStatement stm= con.prepareStatement(query);
       stm.setString(1,sid);
        ResultSet rs=stm.executeQuery();
        while(rs.next()){
            audio=rs.getString("filepath");
        }
       }catch(Exception e){
           System.out.println(e);
       }

        return audio;
    }

    @Override
    public void readAudio(String audioSrcFile, int count) {
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
                System.out.println("4. stop");

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
                }
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound." + ex);
        }
    }
}
