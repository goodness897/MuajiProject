package com.example.mu.myapplication;

public class ItemData {
    public int imageId;
    public String title;
    public String type;
    public String content;
    public String menu1;
    public String menu2;
    public String repremenu;
    public String price;

    public ItemData(int imageId, String title, String type, String content, String menu1, String menu2) {
        this.imageId = imageId;
        this.title = title;
        this.type = type;
        this.content = content;
        this.menu1 = menu1;
        this.menu2 = menu2;
    }

    public ItemData(String repremenu, String price) {
        this.repremenu = repremenu;
        this.price = price;

    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getMenu1() {
        return menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public String getContent() {
        return content;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMenu1(String menu1) {
        this.menu1 = menu1;
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }
}
