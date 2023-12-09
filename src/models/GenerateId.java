package models;

public class GenerateId {
public static int userId = 1;
public static int postId = 1;

public static int userIdGen(){
    return userId++;
}
public static int postIdGen(){
    return postId++;
}
}
