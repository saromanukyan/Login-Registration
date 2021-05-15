package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private String name;
    private String surName;
    private String username;
    private String email;
    private String password;

    public User(String[] fields) {
        setName(fields[0]);
        setSurName(fields[1]);
        setUsername(fields[2]);
        setEmail(fields[3]);
        setPassword(fields[4].trim());
    }

    public User(String text) {
        String[] fields = text.replaceFirst(":", ",").
                replaceFirst(" ", ",").split(",");
        setName(fields[0]);
        setSurName(fields[1]);
        setUsername(fields[2]);
        setEmail(fields[3]);
        this.password = fields[4].trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String lowerCase = name.trim().toLowerCase();
        char firstLetter = Character.toUpperCase(lowerCase.charAt(0));
        this.name = firstLetter + lowerCase.substring(1);
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        String lowerCase = surName.trim().toLowerCase();
        char firstLetter = Character.toUpperCase(lowerCase.charAt(0));
        this.surName = firstLetter + lowerCase.substring(1);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPasswordMD5() {
        return password;
    }

    public void setPassword(String password) {
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
        this.password = hashtext.toString();
    }

    public String getFullName() {
        return getName() + " " + getSurName();
    }

    public String getInfo() {
        return getName() + " " +
                getSurName() + ": " +
                getUsername() + ", " +
                getEmail() + ", " +
                getPasswordMD5();
    }
}

