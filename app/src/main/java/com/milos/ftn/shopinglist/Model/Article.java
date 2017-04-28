package com.milos.ftn.shopinglist.Model;

/**
 * Created by Milos on 4/27/2017.
 */

public class Article {

    private String name;
    private int ammount;
    private boolean done;

    public Article() {
    }

    public Article(String name, int ammount, boolean done) {
        this.name = name;
        this.ammount = ammount;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
