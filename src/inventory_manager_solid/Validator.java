
package inventory_manager_solid;

import java.util.ArrayList;


public class Validator {

    public Validator() {
    }
    
    public boolean validateNumbers(double[] numbers ){
        
        for(double number: numbers){
            if(number < 0) return false;
            if(number == Double.MAX_VALUE || number ==Double.MAX_VALUE) return false;
            if(number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY) return false;
        }
        
        
        return true;
    }
    
    public boolean validateString(String text, ArrayList<Product> list){
        
        for (Product pd : list){
            
            String textCompare = pd.getName().trim().toUpperCase();
            text = text.trim().toLowerCase();
            
            if(text.equals(textCompare)) return false;
        }
        
        return true;
    }
}
