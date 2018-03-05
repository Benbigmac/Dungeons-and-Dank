package com.dontworryaboutit.dungeonsanddank;

/**
 * Created by ovidiubahnean on 2/9/18.
 */

public class User {
    private String UserID;
    private String Name;
    private String Password;

    public User () {}

    public User(String user, String name, String pass)
    {
        super();
        this.UserID = user;
        this.Name = name;
        this.Password = pass;
    }

    public void setUserID(String user)
    {
        UserID = user;
    }

    public String getUserID()
    {
        return this.UserID;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setPassword(String pass)
    {
        this.Password = pass;
    }

    public String getPassword()
    {
        return this.Password;
    }

    @Override
    public  String toString()
    {
          return "User [id=" + UserID + ", Name=" + Name + "Password=" + Password+ "]";
    }
}
