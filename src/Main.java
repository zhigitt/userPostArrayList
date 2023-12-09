import db.DataBase;
import models.Gender;
import models.Post;
import models.User;
import sercice.PostService;
import sercice.UserService;
import sercice.impl.PostServiceImpl;
import sercice.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        DataBase dataBase = new DataBase();

        User logUser = null;

        UserService userService = new UserServiceImpl(dataBase);
        PostService postService = new PostServiceImpl(dataBase);


        while (true) {
            System.out.println("""
                    1. register
                    2. login
                    3. get all users
                    4. stop
                    """);
            System.out.print("select: ");

            switch (sc.nextInt()) {
                case 1 -> {
                    User user = new User();

                    System.out.print("Name: ");
                    user.setName(sc1.nextLine());
                    Loop0:
                    while (true) {
                        try {
                            System.out.print("Email: ");
                            String userEmail = sc1.nextLine();

                            System.out.print("Password: ");
                            String userPass = sc1.nextLine();

                            if (userEmail.endsWith("@gmail.com") && userPass.length() >= 4) {
                                user.setEmail(userEmail);
                                user.setPassowrd(userPass);
                                break Loop0;
                            } else throw new Exception("@gmail.com or pass > 4");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Loop:
                    while (true) {
                        System.out.print("Gender(1. FEMALE  2. MALE): ");
                        int userGender = sc.nextInt();

                        if (userGender == 1) {
                            user.setGender(Gender.FEMALE);
                            break Loop;
                        } else if (userGender == 2) {
                            user.setGender(Gender.MALE);
                            break Loop;
                        } else {
                            System.out.println("ERROR");
                        }
                    }
                    userService.register(user);
                }
                case 2 -> {
                    Loop0:
                    while (true) {
                        try {
                            System.out.print("Email: ");
                            String userEmail = sc1.nextLine();

                            System.out.print("Password: ");
                            String userPass = sc1.nextLine();

                            if (userEmail.endsWith("@gmail.com") && userPass.length() >= 4) {
                                logUser = userService.login(userEmail, userPass);
                                break Loop0;
                            } else throw new Exception("@gmail.com or pass > 4");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    UserPostLoop:
                    while (true){
                        System.out.println("""
                            1. add post
                            2. delete post by id
                            3. get all post by user id
                            4. get user by email
                            5. log out
                            """);
                        System.out.print("select: ");
                        switch (sc.nextInt()){
                            case 1 -> {
                                Post post = new Post();

                                System.out.print("Image url: ");
                                post.setImageUrl(sc1.nextLine());

                                System.out.print("Description: ");
                                post.setDescription(sc1.nextLine());

                                postService.addPostToUser(logUser, post);

                            }
                            case 2 -> {
                                System.out.println("Post ID: ");
                                int idPost = sc1.nextInt();

                                postService.deletePostById(logUser, idPost);
                            }
                            case 3 -> {
                                System.out.print("User ID: ");
                                int id = sc.nextInt();

                                postService.getAllPostById(id);
                            }
                            case 4 -> {
                                System.out.print("User email: ");
                                String email = sc1.nextLine();

                                userService.getUserByEmail(email);
                            }
                            case 5 -> {
                                logUser = null;
                                break UserPostLoop;
                            }
                        }
                    }

                }
                case 3 -> {
                    userService.getAllUsers();
                }
                case 4 -> {
                    System.exit(0);
                }
            }
        }
    }
}