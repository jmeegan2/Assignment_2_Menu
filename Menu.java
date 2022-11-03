import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Menu {

    //Going to be using ArrayList
    private ArrayList<MenuItem> arrayList;

    private MenuItem menuItem;
    int index = 0;

    //Static constants that have been given by assignment paper
    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;
    public static final boolean HEART_HEALTHY = true;
    public static final boolean NOT_HEART_HEALTHY = false;

    public Menu() {
        arrayList = new ArrayList<MenuItem>();
    }

    //adds menuItem to arraylist
    public void add(MenuItem menuItem) {
        arrayList.add(menuItem);
    }

    //removes item from arraylist
    public void removeItem(MenuItem menuItem) {
        arrayList.remove(menuItem);
    }

    //searches for items and if found removes item
    public boolean searchItem(String name) {
        for (MenuItem menuItem : arrayList) {
            if (menuItem.getItemName().equals(name)) {
                removeItem(menuItem);
                return true;
            }
        }
        return false;
    }

    //AllItemIterator
    private class AllItemIterator implements MenuIterator {
        int count = 0;
        MenuItem menuItems;

        public AllItemIterator(MenuItem menuItems) {
            this.menuItems = menuItem;
        }

        @Override
        public boolean hasNext() {
            if (count > arrayList.size() - 1 || arrayList.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public MenuItem next() {
            if (count < 0) throw new NoSuchElementException();
            else {
                return arrayList.get(count++);
            }
        }
    }

    //Helper method for the get all items iterator
    public MenuIterator getAllItemsIterator() {
        return new AllItemIterator(menuItem);
    }

    private class ItemIterator implements MenuIterator {
        MenuItem menuItem;
        int count = 0;
        int category;

    public ItemIterator(int category, MenuItem menuItem) {
        this.category = category;
        this.menuItem = menuItem;
    }

        @Override
        public boolean hasNext() {
           if(count > arrayList.size() - 1 || arrayList.isEmpty()) {
               return false;
           }
           else {
               return true;
           }
        }

        @Override
        public MenuItem next() {
            if(count < 0) throw new NoSuchElementException();
            else {
                return arrayList.get(count++);
            }
        }
    }

    //Helper method
    public MenuIterator getItemIterator(int category) {
        return new ItemIterator(category, menuItem);
    }

    //Heart Healthy iterator
    private class HeartHealthyIterator implements MenuIterator {
        MenuItem menuItem;
        int count = 0;

        public HeartHealthyIterator(MenuItem menuItem) {
            this.menuItem = menuItem;
        }

        @Override
        public boolean hasNext() {
            if (count > arrayList.size() - 1 || arrayList.isEmpty() || NOT_HEART_HEALTHY) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public MenuItem next() {
            if (count < 0) {
                throw new NoSuchElementException();
            } else {
                return arrayList.get(count++);
            }
        }
    }

    // helper method for heart healthy iterator
    public MenuIterator getHeartHealthyIterator(){
        return new HeartHealthyIterator(menuItem);
    }

    //Iterator for the price
    private class PriceIterator implements MenuIterator{
    MenuItem menuItem;
    int count = 0;
    double price;

    //Price iterator that goes through the prices for menuItems
    public PriceIterator(double price, MenuItem menuItem) {
        this.price = price;
        this.menuItem = menuItem;
    }
        @Override
        public boolean hasNext() {
            if (count > arrayList.size() - 1 || arrayList.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public MenuItem next() {
            if (count < 0) throw new NoSuchElementException();
            else {
                return arrayList.get(count++);
            }
        }
    }
    //Helper method for price iterator
    public MenuIterator getPriceIterator(double price) {
        return new PriceIterator(price, menuItem);
    }
}
