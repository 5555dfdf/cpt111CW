package utils;

import models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String USERS_PATH = "src/resources/users.csv";
    public static List<User> loadUsers() {

        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    users.add(new User(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
