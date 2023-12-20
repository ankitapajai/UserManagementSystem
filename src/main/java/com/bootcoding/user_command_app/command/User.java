package com.bootcoding.user_command_app.command;

public class User {
    private String id;
    private String username;
    private String mail_id;
    private String phone;
    private String address;

    public User(String id, String username) {

    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public User(String id, String username, String mail_id, String phone, String address) {
        this.id = id;
        this.username = username;
        this.mail_id =  mail_id;
        this.phone = phone;
        this.address = address;
    }
}
