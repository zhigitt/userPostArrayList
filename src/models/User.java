package models;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String email;
    private String passowrd;
    private Gender gender;
    private ArrayList<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(int userId, String name, String email, String passowrd, Gender gender, ArrayList<Post> posts) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passowrd = passowrd;
        this.gender = gender;
        this.posts = posts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passowrd='" + passowrd + '\'' +
                ", gender=" + gender +
                ", posts=" + posts +
                '}';
    }
}