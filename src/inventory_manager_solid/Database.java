package inventory_manager_solid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Database {

    public Database() {
    }

    public void saveData(ArrayList<Product> inventory) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(inventory);

        try (FileWriter fileWriter = new FileWriter("lista_objetos.json")) {
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error al guardar la lista de objetos: " + e.getMessage());
        }
    }

    public ArrayList<Product> readData() {

        try {
            Gson gson = new GsonBuilder().create();
            FileReader fileReader = new FileReader("lista_objetos.json");

            Type typeListPerson = new TypeToken<ArrayList<Product>>() {
            }.getType();

            ArrayList<Product> result = gson.fromJson(fileReader, typeListPerson);

            return result;

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return null;
    }

}
