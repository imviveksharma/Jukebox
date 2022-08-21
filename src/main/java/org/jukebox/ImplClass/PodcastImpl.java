package org.jukebox.ImplClass;

import org.jukebox.DBConnection;
import org.jukebox.Interfaces.PodcastInterface;
import org.jukebox.Model.Podcast;
import org.jukebox.Model.Songs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PodcastImpl implements PodcastInterface {
    Connection con = DBConnection.getConnection();
    Scanner sc=new Scanner(System.in);

    @Override
    public List<Podcast> displayAllPodcast() {
        List<Podcast> podcastList = null;
        try {
            Statement st = con.createStatement();
            String Query = "select * from podcast";
            podcastList = new ArrayList<>();
            ResultSet rs = st.executeQuery(Query);
            while (rs.next()) {
                Podcast podcast = new Podcast(rs.getString("podcastid"), rs.getString("podcastname"), rs.getInt("episodes"), rs.getString("filepat"));
                podcastList.add(podcast);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return podcastList;

    }

    @Override
    public List<Podcast> sortAllPodcast() {

        List<Podcast> sortpodcast=null;
        try{
            Statement st= con.createStatement();
            String Query1=null;
            System.out.println("Sort Based On\n1.Podcast Id\n2.Podcast Name");
            int choice=sc.nextInt();
            switch(choice){
                case 1: Query1="select * from podcast order by podcastid"; break;
                case 2: Query1="select * from podcast order by podcastname"; break;
                default:
                    System.out.println("Invalid Choice");break;
            }
            sortpodcast=new ArrayList<>();
            ResultSet rs= st.executeQuery(Query1);
            while(rs.next()){
                Podcast sort=new Podcast(rs.getString("podcastid"), rs.getString("podcastname"), rs.getInt("episodes"), rs.getString("filepat"));
                sortpodcast.add(sort);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return sortpodcast;
    }

    @Override
    public List<Podcast> searchPodcast(String pid) {
        List<Podcast> search = null;
        try {
            String Query2 = "select * from podcast where podcastid=?";
            PreparedStatement p = con.prepareStatement(Query2);
            p.setString(1,pid);
            search = new ArrayList<>();
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Podcast plist = new Podcast(rs.getString("podcastid"), rs.getString("podcastname"), rs.getInt("episodes"), rs.getString("filepat"));
                search.add(plist);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return search;

    }

    @Override
    public String getpodcastId() {
        String audio=null;
        try{ System.out.println("Enter Podcast Id");
            String sid=sc.nextLine();
            String query= "select filepat from podcast where podcastid=?";
            PreparedStatement stm= con.prepareStatement(query);
            stm.setString(1,sid);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                audio=rs.getString("filepat");
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return audio;
    }
}
