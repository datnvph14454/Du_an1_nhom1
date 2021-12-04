package com.poly.testgit.user;

public class user {
    private String username;
    private String password;
    private String repasswprd;
    private String phone;
    private String hoten;


    public user() {
    }

    public user(String username, String password, String repasswprd, String phone, String hoten) {
        this.username = username;
        this.password = password;
        this.repasswprd = repasswprd;
        this.phone = phone;
        this.hoten = hoten;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepasswprd() {
        return repasswprd;
    }

    public void setRepasswprd(String repasswprd) {
        this.repasswprd = repasswprd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repasswprd='" + repasswprd + '\'' +
                ", phone='" + phone + '\'' +
                ", hoten='" + hoten + '\'' +
                '}';
    }
}
