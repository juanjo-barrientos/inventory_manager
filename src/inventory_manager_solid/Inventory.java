package inventory_manager_solid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private ArrayList<Product> inventoryList = new ArrayList<>();

    public Inventory(ArrayList<Product> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public Inventory() {
    }

    public ArrayList<Product> getInventoryList() {
        return inventoryList;
    }

    public Product createNewProduct(String name, double price, int stock) {
        Product pd = new Product(name, price, stock);
        return pd;
    }

    public void addNewProduct(Product pd) {
        this.inventoryList.add(pd);
    }

    public Product deleteProduct(String name) {
        this.inventoryList = filterProducts(name);
        Product deleteProduct = findProduct(name);
        return deleteProduct;
    }

    public Product updateProduct(String name, Product newPd) {
        Product pd = findProduct(name);
        pd = newPd;
        return pd;
    }

    public ArrayList<Product> filterProducts(String name) {

        List<Product> pd = inventoryList.stream()
                .filter(product -> !product.getName().equals(name))
                .collect(Collectors.toList());

        return (ArrayList<Product>) pd;
    }

    public Product findProduct(String name) {

        List<Product> pd = inventoryList.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());

        return pd.get(0);
    }

}
