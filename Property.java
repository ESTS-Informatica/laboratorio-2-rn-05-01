

/**
 * A property to sell.
 *
 * @author POO
 * @version 03/2024
 */
public class Property {

    private static int numberOfProperties = 0;
    private final String id;
    private String description;
    private double price;

    /**
     * Constructor of class Property
     *
     * @param description The property description.
     * @param price The property price.
     */
    public Property(String description, double price) {
        this.description = description;
        this.price = price;
        this.id = Integer.toString(++numberOfProperties);
    

    }

    /**
     * Id selector.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Description selector.
     */
    public String getDescription() {
        return this.description;

    }

    /**
     * Description modifier.
     * 
     * @param description The new description. Must not be null.
     */
    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }

    }

    /**
     * Price selector.
     */
    public double getPrice() {
        return this.price;
        
    }
    
    /**
     * Price modifier.
     * 
     * @param price The new price. Must not be negative.
     */
    public void setPrice(double price) {
         if (price >= 0) {
            this.price = price;
        }

    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
