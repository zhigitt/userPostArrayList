package sercice.impl;

import db.DataBase;
import models.GenerateId;
import models.Post;
import models.User;
import sercice.PostService;

import java.util.ArrayList;

public class PostServiceImpl implements PostService {
    DataBase dataBase;

    public PostServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addPostToUser(User user, Post post) {
        post.setPostId(GenerateId.postIdGen());
        user.getPosts().add(post);
    }

    @Override
    public void deletePostById(User user, int id) {
        for (Post post : user.getPosts()) {
            if (post.getPostId() == id){
                user.getPosts().remove(post);
                return;
            }
        }
    }

    @Override
    public void getAllPostById(int id) {
        for (User user : dataBase.users) {
            if (user.getUserId() == id){
                System.out.println(user.getPosts());
                return;
            }
        }
    }
}
