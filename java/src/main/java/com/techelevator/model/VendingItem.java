package com.techelevator.model;

public class VendingItem {
    private String location;
    private int itemId;
    private String name;
    private String type;
    private int price;
    private int inventory;
    private String imageUrl;

    public VendingItem() {
        location = "m2";
        itemId = -1;
        name = "Default Name";
        type = "Default Type";
        price = -1;
        inventory = -1;

    }

    public VendingItem(String location, int itemId, String name, String type, int price, int inventory) {
        this.location = location;
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.inventory = inventory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
