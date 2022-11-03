import java.lang.reflect.Array;
import java.util.ArrayList;

public class MenuItem {

//Initialization of variables for various aspects of the dish
    private String itemName;
    private double price;
    private int category;
    private boolean heartHealthy;
    ArrayList<MenuItem> arrayList = new ArrayList<>();

    public MenuItem(String itemName, int category, boolean heartHealthy, double price) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.heartHealthy = heartHealthy;
    }
    //method to return name
    public String getItemName()
    {
        return itemName;
    }

    //method to return the price
    public double getPrice()
    {
        return price;
    }
    //method to return category
    public int getCategory()
    {
        return category;
    }
    //method to get heart healthy status
    public boolean getHeartHealthy()
    {
        return heartHealthy;
    }

    //method to set heart healthy to true
    public void setHeartHealthy(boolean heartHealthy) {
        this.heartHealthy = heartHealthy;
    }

    //method to set item name
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    //method to set price
    public void setPrice(double price) {
        this.price = price;
    }
}
