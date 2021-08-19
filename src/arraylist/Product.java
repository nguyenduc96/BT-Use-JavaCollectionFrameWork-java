package arraylist;

public class Product implements Comparable<Product> {
    private String name;
    private String idProduct;
    private int price;

    public Product() {
    }

    public Product(String name, String idProduct, int price) {
        this.name = name;
        this.idProduct = idProduct;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name = '" + name + '\'' +
                ", idProduct = '" + idProduct + '\'' +
                ", price = " + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return (this.getPrice() < o.getPrice() ? -1 : (this.getPrice() == o.getPrice() ? 0 : 1));
    }
}
