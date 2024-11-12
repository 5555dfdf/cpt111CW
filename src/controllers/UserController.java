package controllers;

import models.User;
import utils.FileHandler;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private List<User> users;
    private User currentUser;


    public void loadUsers() {
        users = FileHandler.loadUsers();
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("登录成功！");
                return;
            }
        }
        System.out.println("用户名或密码错误！");
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

