public class Item {
    String description;
    double price;
    
    public Item () {}
    public Item (String description, double price) {
        this.description = description;
        this.price = price;
    }
    
    public void setDescription (String description) {
        this.description = description;
    }
    public void setPrice (double price) {
        this.price = price;
    }
    
    public String getDescription () {
        return description;
    }
    public double getPrice () {
        return price;
    }
}
