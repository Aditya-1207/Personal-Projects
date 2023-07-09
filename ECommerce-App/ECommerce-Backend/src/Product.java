public class Product {

    private String id;
    private String name;
    private String inventory_Status;
    private Double mrp_Price;
    private Double discount;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory_Status(String inventory_Status) {
        this.inventory_Status = inventory_Status;
    }

    public void setMrp_Price(Double mrp_Price) {
        this.mrp_Price = mrp_Price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setMax_allowed_quantity(int max_allowed_quantity) {
        this.max_allowed_quantity = max_allowed_quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInventory_Status() {
        return inventory_Status;
    }

    public Double getMrp_Price() {
        return mrp_Price;
    }

    public Double getDiscount() {
        return discount;
    }

    public int getMax_allowed_quantity() {
        return max_allowed_quantity;
    }

    public int max_allowed_quantity;

    public Product(String id, String name, String inventory_Status, Double mrp_Price, Double discount, int max_allowed_quantity) {
        this.id = id;
        this.name = name;
        this.inventory_Status = inventory_Status;
        this.mrp_Price = mrp_Price;
        this.discount = discount;
        this.max_allowed_quantity = max_allowed_quantity;
    }



    public static void main(String[] args) {
        String filePath = "C:\\Aditya\\OneDrive - TECHNIA AB\\Personal-Projects\\products.csv";
        ProductCatalog catalog = new ProductCatalog(filePath);
        System.out.println(catalog.searchProduct("Product1"));
        catalog.globalSearch("13.7");

    }
}
