public class MenuItem {

    private String ItemName;
    private String Price;
    private int Category;
    private boolean heartHealthy;

    public MenuItem(String ItemName, int Category, boolean heartHealthy, String Price) {
        this.ItemName = ItemName;
        this.Price = Price;
        this.Category = Category;
        this.heartHealthy = heartHealthy;
    }

    public String getItemName()
    {
        return ItemName;
    }

    public String getPrice()
    {
        return Price;
    }
    public int getCategory()
    {
        return Category;
    }
    public boolean getHeartHealthy()
    {
        return heartHealthy;
    }
}
