// --== CS400 File Header Information ==--
// Name: Yash Butani
// Email: @wisc.edu
// Team: Blue
// Group: KE
// TA: Keren
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 *
 * Product class which represents the type that all objects in the tree will be
 */
public class Product implements ProductInterface
{
    int ID;
    String name;
    int quantity_sold;
    int quantity_available;
    double cost;
    double retail_price;

    // please make sure you add in comments
    public Product(int id, String name, int qs, int qa, double c, double rp)
    {
        this.ID = id;
        this.name = name;
        this.quantity_sold = qs;
        this.quantity_available = qa;
        this.cost = c;
        this.retail_price = rp;
    }
    @Override
    public double getRetailPrice()
    {
        return retail_price;
    }
    @Override
    public double getCost()
    {
        return this.cost;
    }
    @Override
    public int getQuantityAvailable() {
        return this.quantity_available;
    }
    @Override
    public int getQuantitySold()
    {
        return this.quantity_sold;
    }
    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public int getID()
    {
        return this.ID;
    }

    @Override
    public java.lang.String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", quantity_sold=" + quantity_sold +
                ", quantity_available=" + quantity_available +
                ", cost=" + cost +
                ", retail_price=" + retail_price +
                '}';
    }
}