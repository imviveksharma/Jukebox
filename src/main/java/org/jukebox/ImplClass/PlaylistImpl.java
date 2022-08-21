package org.jukebox.ImplClass;

import org.jukebox.DBConnection;
import org.jukebox.Interfaces.PlaylistInterface;
import org.jukebox.Model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class PlaylistImpl implements PlaylistInterface {
    Connection con = DBConnection.getConnection();
    Playlist p=new Playlist();
    Scanner sc=new Scanner(System.in);


    @Override
    public void create_playlist() {
        try{System.out.println("Enter Your Username");
        p.setUsername(sc.nextLine());
        System.out.println("Enter Playlist Id");
        p.setPlaylistid(sc.nextLine());
        System.out.println("Set Playlist Name");
        p.setPlaylistname(sc.nextLine());
        Statement st=con.createStatement();
        String query="insert into playlist values('" + p.getPlaylistid() + "','" + p.getUsername() + "','" + p.getPlaylistname() + "')";
         st.executeUpdate(query);
        System.out.println("Playlist Created");}catch(Exception e){
            System.out.println("Username not exists");
        }
    }

    @Override
    public void delete_playlist() {
        try {
            System.out.println("Enter Playlist id which you want to delete");
            p.setPlaylistid(sc.nextLine());
            String query1="delete from playlist where playlistid=?";
            PreparedStatement pst= con.prepareStatement(query1);
            pst.setString(1,p.getPlaylistid());
            pst.executeUpdate();
            System.out.println("Playlist Deleted Successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
