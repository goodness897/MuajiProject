package wherestreet.muaji.com.myapplication;

public class ItemData {
    private int imageId;
    private String title;
    private String type;
    private String content;
    private String menu1;
    private String menu2;
    private String repremenu;
    private String price;

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

    public String getRepremenu() {
        return repremenu;
    }

    public void setRepremenu(String repremenu) {
        this.repremenu = repremenu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
