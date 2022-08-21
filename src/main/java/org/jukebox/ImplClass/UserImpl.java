package org.jukebox.ImplClass;

import org.jukebox.DBConnection;
import org.jukebox.Interfaces.UserInterface;
import org.jukebox.Model.User;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserImpl implements UserInterface {
    Connection con = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    User u = new User();
    @Override
    public void create_id() {
        while(true) {
            System.out.println("*************************Enter Your Details For Registration**************************");
            try {
                System.out.println("Enter UserName");
                u.setUsrname(sc.nextLine());
                if(isValidUsername(u.getUsrname())){
                    Statement st = con.createStatement();
                    String query = "select * from user";
                    ResultSet rs = st.executeQuery(query);
                    String chk;
                    int flag = 0;
                    while (rs.next()) {
                        chk = rs.getString("username");
                        if (chk.equals(u.getUsrname())) {
                            flag = 1;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Set Password");
                        u.setPassword(sc.nextLine());
                        if(isValidPassword(u.getPassword())){
                            System.out.println("Enter Mobile Number");
                            u.setMobileno(sc.nextLine());
                            if(isValidMobileNo(u.getMobileno())){
                                String query1 = "select * from user";
                                ResultSet rs1 = st.executeQuery(query1);
                                String chk1;
                                int flag1 = 0;
                                while (rs1.next()) {
                                    chk1 = rs1.getString("mobileno");
                                    if (chk1.equals(u.getMobileno())) {
                                        flag1 = 1;
                                    }
                                }
                                if (flag1 == 0) {
                                    String query2 = "insert into user values('" + u.getUsrname() + "','" + u.getPassword() + "'," + u.getMobileno() + ")";
                                    st.executeUpdate(query2);
                                    System.out.println("Registered Successfully");

                                } else {
                                    System.out.println("Mobile Number Exists in Database");
                                    continue;
                                }
                            }else{
                                System.out.println("Invalid Mobile no.");
                                break;
                            }
                        }else{
                            System.out.println("Invalid Password.Use Min. 8 words in which one special char.,digit and upper and lowercase letters");break;
                        }

                    } else {
                        System.out.println("Username Already Exists.Try Again with Different");
                        continue;
                    }
                }else{
                    System.out.println("Enter Alphanumeric Values of Min. 8 length");
                }

            } catch (Exception e) {
                System.out.println(e);
            } break;
        }
    }

    @Override
    public void update_id() {
       try {
           System.out.println("Enter Username");
           u.setUsrname(sc.nextLine());
           Statement st = con.createStatement();
           String query3 = "select * from user";
           ResultSet rs2 = st.executeQuery(query3);
           String chk2;
           int flag2 = 0;
           while (rs2.next()) {
               chk2 = rs2.getString("username");
               if (chk2.equals(u.getUsrname())) {
                   flag2 = 1;
               }
           }
           if (flag2 == 1) {
               System.out.println("Enter New Username");
               String newuser=sc.nextLine();
               String query4="Update user set username=? where username=?";
               PreparedStatement stmt= con.prepareStatement(query4);
               stmt.setString(1,newuser);
               stmt.setString(2,u.getUsrname());
               stmt.executeUpdate();
               System.out.println("Update Successfully");

           }else{
               System.out.println("Username Is Missing in Database");
           }

       } catch (Exception x) {
           System.out.println(x);
       }
    }

    @Override
    public void login() {
        while (true) {
            try {
                System.out.println("Enter Username");
                u.setUsrname(sc.nextLine());
                Statement st = con.createStatement();
                String query5 = "select * from user";
                ResultSet rs3 = st.executeQuery(query5);
                String chk3;
                int flag3 = 0;
                while (rs3.next()) {
                    chk3 = rs3.getString("username");
                    if (chk3.equals(u.getUsrname())) {
                        flag3 = 1;
                    }
                }
                if (flag3 == 1) {
                    System.out.println("Enter Your Password");
                    u.setPassword(sc.nextLine());
                    String query6 = "select * from user";
                    ResultSet rs4 = st.executeQuery(query6);
                    String chk4;
                    int flag4 = 0;
                    while (rs4.next()) {
                        chk4 = rs4.getString("password");
                        if (chk4.equals(u.getPassword())) {
                            flag4 = 1;
                        }
                    }
                    if (flag4 == 1) {
                        System.out.println("Opening Your Account.........");
                        break;
                    }else{
                        System.out.println("Password Is Wrong");
                        continue;
                    }

                }else{
                    System.out.println("Username is Wrong");
                    continue;
                }
            } catch (Exception x) {
                System.out.println(x);
            }
          }
       }

    public static boolean isValidMobileNo(String str){
      Pattern ptrn=Pattern.compile("[6-9][0-9]{9}");
      Matcher match= ptrn.matcher(str);

        return (match.find()&&match.group().equals(str));
    }

    public static boolean isValidUsername(String str){
        Pattern ptrn=Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8}$");
        Matcher match= ptrn.matcher(str);

        return (match.find()&&match.group().equals(str));
    }

    public static boolean isValidPassword(String str){
        Pattern ptrn=Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$");
        Matcher match= ptrn.matcher(str);

        return (match.find()&&match.group().equals(str));
    }
    }
