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

        Product deleteProduct = findProduct(name);
        this.inventoryList = filterProducts(name);
        return deleteProduct;
    }

    public Product deleteProduct(String id, boolean a) {

        Product deleteProduct = findProduct(id, a);
        this.inventoryList = filterProducts(id, a);
        return deleteProduct;
    }

    public Product updateProduct(int index, Product newPd) {
        this.inventoryList.set(index, newPd);
        return newPd;
    }

    public ArrayList<Product> filterProducts(String name) {

        List<Product> pd = inventoryList.stream()
                .filter(product -> !product.getName().equals(name))
                .collect(Collectors.toList());

        return (ArrayList<Product>) pd;
    }

    public ArrayList<Product> filterProducts(String id, boolean a) {

        List<Product> pd = inventoryList.stream()
                .filter(product -> !product.getId().equals(id))
                .collect(Collectors.toList());

        return (ArrayList<Product>) pd;
    }

    public Product findProduct(String name) {

        List<Product> pd = inventoryList.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());

        if (pd != null && pd.isEmpty() == false) {
            return pd.get(0);
        }

        return null;
    }

    public Product findProduct(String id, boolean a) {

        List<Product> pd = inventoryList.stream()
                .filter(product -> product.getId().equals(id))
                .collect(Collectors.toList());

        if (pd != null && pd.isEmpty() == false) {
            return pd.get(0);
        }

        return null;
    }

}
