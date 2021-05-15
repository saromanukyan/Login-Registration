package model;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    public static User create(String[] fields) {
        return new User(fields);
    }

    public static User create(String text) {
        return new User(text);
    }

    public static void addUserToFile(User user) {
        try {
            Files.write(Paths.get("data\\database.txt"),
                    ("\n" + user.getInfo()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> map() {
        List<String> usersList = new ArrayList<>();
        try {
            usersList = Files.readAllLines(Paths.get("data\\database.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        for (String s : usersList) {
            User user = create(s);
            map.put(user.getUsername(), user.getPasswordMD5());
        }
        return map;
    }

    public static boolean isUserAlreadyExist(String username) {
        return map().containsKey(username);
    }

    public static boolean isValidUsernameAndPassword(String username, String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        assert md != null;
        byte[] messageDigest = md.digest(password.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        StringBuilder hashtext = new StringBuilder(no.toString(16));
        while (hashtext.length() < 32) {
            hashtext.insert(0, "0");
        }

        Map<String, String> map = map();
        return map.containsKey(username) && map.get(username).equals(hashtext.toString()); // MD5
    }

}
