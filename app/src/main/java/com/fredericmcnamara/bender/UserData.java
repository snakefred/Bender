package com.fredericmcnamara.bender;

import java.io.Serializable;

/**
 * Created by fredericmcnamara on 16-05-09.
 */
public class UserData implements Serializable {
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
