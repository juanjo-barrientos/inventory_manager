package inventory_manager_solid;

public class Main {

    public static void main(String[] args) {

        Inventory inv = new Inventory();
        Database db = new Database();
        AppUI app = new AppUI(inv, db);

        app.setVisible(true);
    }

}
