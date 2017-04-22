package com.dannyroa.espresso_samples.recyclerview;

/**
 * Created by AnjaliUnnikrishnan on 22/04/17.
 */

public class Sub_Team {

    private String name;
    private boolean isFollowing;

    public Sub_Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

}
