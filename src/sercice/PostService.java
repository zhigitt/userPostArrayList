package sercice;

import models.Post;
import models.User;

import java.util.ArrayList;

public interface PostService {
    void addPostToUser(User user, Post post);
    void deletePostById(User user,int id);
    void getAllPostById(int id);
}
