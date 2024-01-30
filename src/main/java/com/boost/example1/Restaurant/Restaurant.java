package com.boost.example1.Restaurant;


public class Restaurant {
    public String id;
    public String name;
    public String category;

    public Restaurant(String _id, String _name, String _category){
        id = _id;
        name = _name;
        category = _category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

}
