package com.liraz.cookit.model;

public class User
{
    private static User theUser = null;

    public String userUsername;
    public String userEmail;
    public String userId;
    public String passsord;
    public String address;

    private User()
    {
        userEmail = null;
        userUsername = null;
        passsord = null;
        address = null;
        userId = null;
    }

    // static method to create instance of Singleton class
    public static User getInstance()
    {
        if (theUser == null)
            theUser = new User();

        return theUser;
    }
}
