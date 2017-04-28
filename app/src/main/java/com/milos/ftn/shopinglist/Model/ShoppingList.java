package com.milos.ftn.shopinglist.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milos on 4/27/2017.
 */

public class ShoppingList {
    private String name;
    private List<Article> articles = new ArrayList<>();

    public ShoppingList() {
    }

    public ShoppingList(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
    }

    public ShoppingList(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
