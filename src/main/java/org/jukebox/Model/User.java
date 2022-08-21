package org.jukebox.Model;

public class User {
    private String usrname;
    private String password;
    private String mobileno;

    public User(String usrname, String password, String mobileno) {
        this.usrname = usrname;
        this.password = password;
        this.mobileno = mobileno;
    }

    public User() {
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "User{" +
                "usrname='" + usrname + '\'' +
                ", password='" + password + '\'' +
                ", mobileno=" + mobileno +
                '}';
    }
}
