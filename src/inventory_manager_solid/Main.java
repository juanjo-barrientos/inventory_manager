package inventory_manager_solid;

public class Main {

    public static void main(String[] args) {

        Inventory inv = new Inventory();
        AppUI app = new AppUI(inv);

        app.setVisible(true);
    }

}
