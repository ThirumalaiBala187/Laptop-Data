package ShoppingCartSystem;

public class Product {
    
    String name;

    String brand;

    String category;

    String productType;

    int price;

    byte availableQuantity;

    double discount;

    int noOfLikes;

    byte quantitySold;

    int productId;

    static int productIdCounter= 1001;

    Product(String name, String brand, String category, String productType, int price, byte availableQuantity, double discount, int noOfLikes, byte quantitySold){

        this.productId = productIdCounter;

        this.name = name;

        this.brand = brand;

        this.category = category;

        this.productType = productType;

        this.price = price;

        this.availableQuantity = availableQuantity;

        this.discount = discount;

        this.noOfLikes = noOfLikes;

        this.quantitySold = quantitySold;
        
        productIdCounter++;        

    }

    Product(int productId, String name, String brand, String category, String productType, int price, byte availableQuantity, double discount, int noOfLikes, byte quantitySold){

        this.productId = productId;

        this.name = name;

        this.brand = brand;

        this.category = category;

        this.productType = productType;

        this.price = price;

        this.availableQuantity = availableQuantity;

        this.discount = discount;

        this.noOfLikes = noOfLikes;

        this.quantitySold = quantitySold;  
        
        if(productId >= productIdCounter){

            productIdCounter = productId+1;

        }   

    }

    public void setProductId() {

        this.productId = productIdCounter;

        productIdCounter++;

    }

    public int getProductId() {

        return productId;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void setBrand(String brand) {

        this.brand = brand;

    }

    public String getBrand() {

        return brand;

    }

    public void setCategory(String category) {

        this.category = category;

    }

    public String getCategory() {

        return category;

    }

    public void setProductType(String productType) {

        this.productType = productType;

    }

    public String getProductType() {

        return productType;

    }

    public void setPrice(int price) {

        this.price = price;
    
    }

    public int getPrice() {

        return price;

    }

    public void setAvailableQuantity(byte availableQuantity) {

        this.availableQuantity = availableQuantity;

    }

    public byte getAvailableQuantity() {

        return availableQuantity;

    }

    public void setDiscount(double discount) {

        this.discount = discount;

    }

    public double getDiscount() {

        return discount;

    }

    public void setNoOfLikes(int noOfLikes) {

        this.noOfLikes = noOfLikes;

    }

    public int getNoOfLikes() {

        return noOfLikes;

    }

    public void setQuantitySold(byte quantitySold) {

        this.quantitySold = quantitySold;

    }

    public byte getQuantitySold() {

        return quantitySold;

    }

    @Override

    public String toString(){

        System.out.println("\n+------------------------------------------------------------------------------+");

        System.out.printf("%-2s %-50s %-2s", "|","\t\t\t\tProduct Details","|");

        System.out.println("\n|------------------------------------------------------------------------------|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Id", "|", productId,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Name", "|", name,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Brand", "|", brand,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Price", "|", price,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Discount", "|", discount + "%","|");

        System.out.println("|------------------------------------------------------------------------------|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Final Price", "|", (price - (price*(discount/100))) ,"|");

        return "+------------------------------------------------------------------------------+";

    }
    

    public void printBill(){

        System.out.println("\n+------------------------------------------------------------------------------+");

        System.out.printf("%-2s %-50s %-2s", "|","\t\t\t\tTax Invoice","|");

        System.out.println("\n|------------------------------------------------------------------------------|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Id", "|", productId,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Name", "|", name,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Category", "|", category,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Type", "|", productType,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Brand", "|", brand,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Price", "|", price,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Discount", "|", discount + "%","|");

        System.out.println("|------------------------------------------------------------------------------|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Final Price", "|", (price - (price*(discount/100))) ,"|");

        System.out.println("+------------------------------------------------------------------------------+"); 

    }
    
}
