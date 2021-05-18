package Accessories_Details_Controllers;


import javafx.scene.text.Text;

public class Item {

    private String ID;
    private String name;
    private String price;
    private String price_range;
    private String Category;
    private String Quality;
    private String Quantity;
    private Text Status;

    public Item(String ID, String name, String price, String price_range, String Category, String Quality)
    {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.price_range = price_range;
        this.Category = Category;
        this.Quality = Quality;
    }



    public Item(String ID, String name, String price, String price_range, String Category, String Quality, String Quantity, Text Status)
    {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.price_range = price_range;
        this.Category = Category;
        this.Quality = Quality;
        this.Quantity = Quantity;
        this.Status = Status;
    }

    public Text getStatus() {
        return Status;
    }

    public void setStatus(Text status) {
        Status = status;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPrice_range() {
        return price_range;
    }

    public String getCategory() {
        return Category;
    }

    public String getQuality() {
        return Quality;
    }

    public String getQuantity() {
        return Quantity;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setQuality(String quality) {
        this.Quality = quality;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    @Override
    public boolean equals(Object o)
    {
        if((o instanceof Item ) && ((Item)o).ID.equals(ID) && ((Item)o).name.equals(name) && ((Item)o).price.equals(price) && ((Item)o).price_range.equals(price_range) && ((Item)o).Category.equals(Category) && ((Item)o).Quality.equals(Quality))
            return true;
        return false;
    }


    public String toString()
    {
        return this.ID + "\n";
    }
}
