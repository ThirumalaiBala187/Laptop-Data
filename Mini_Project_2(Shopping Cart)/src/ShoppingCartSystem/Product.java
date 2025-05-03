package ShoppingCartSystem;

public class Product {
    
    private String name;

    private int categoryId;

    private  int productTypeId;

    private int brandId;

    private long price;

    private byte availableQuantity;

    private double discount;

    private int noOfLikes;

    private byte quantitySold;

    private int productId;

    private static int productIdCounter= 1001;
    
    Product(){

        //To create a object to call the method.

    }

    Product(String name, int categoryId, int productTypeId, int brandId, long price, byte availableQuantity, double discount, int noOfLikes, byte quantitySold){

        this.productId = productIdCounter;

        this.name = name;

        this.categoryId = categoryId;

        this.productTypeId = productTypeId;

        this.brandId = brandId;

        this.price = price;

        this.availableQuantity = availableQuantity;

        this.discount = discount;

        this.noOfLikes = noOfLikes;

        this.quantitySold = quantitySold;
        
        productIdCounter++;        

    }

    Product(int productId, String name,  int categoryId, int productTypeId, int brandId, long price, byte availableQuantity, double discount, int noOfLikes, byte quantitySold){

        this.productId = productId;

        this.name = name;

        this.categoryId = categoryId;

        this.productTypeId = productTypeId;

        this.brandId = brandId;

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

    public void setBrandId(int brandId) {

        this.brandId = brandId;

    }

    public int getBrandId() {

        return brandId;

    }

    public void setCategory(int categoryId) {

        this.categoryId = categoryId;

    }

    public int getCategoryId() {

        return categoryId;

    }

    public void setProductType(int productTypeId) {

        this.productTypeId = productTypeId;

    }

    public int getProductTypeId() {

        return productTypeId;

    }

    public void setPrice(long price) {

        this.price = price;
    
    }

    public long getPrice() {

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

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Brand", "|", brandId,"|");

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

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Category", "|", categoryId,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Type", "|", categoryId,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Brand", "|", brandId,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Price", "|", price,"|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Product Discount", "|", discount + "%","|");

        System.out.println("|------------------------------------------------------------------------------|");

		System.out.printf("%-2s %-20s %-2s %-51s %-2s %n", "|", "Final Price", "|", (price - (price*(discount/100))) ,"|");

        System.out.println("+------------------------------------------------------------------------------+"); 

    }
    
}
