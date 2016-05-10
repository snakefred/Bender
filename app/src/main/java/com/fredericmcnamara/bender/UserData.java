package com.fredericmcnamara.bender;

/**
 * Created by fredericmcnamara on 16-05-09.
 */
public class UserData {
    private long id;
    private String user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void UserData(String name )
    {
        this.setUser(name);
    }
}
