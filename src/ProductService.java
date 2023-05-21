import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products=new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }

    public  List<Product> getAllProduct(){
        return products;
    }
    public Product getProduct(String name){
        for(Product pd:products) {
            if (pd.getName().equals(name) )
                return pd;
        }
            return null;

    }



    public List<Product> getProductBasedOnText(String ptext){
        List<Product> proBonT=new ArrayList<>();
        String text=ptext.toLowerCase();
        for(Product pdtext:products) {
            if (pdtext.getName().toLowerCase().contains(text) || pdtext.getType().toLowerCase().contains(text) || pdtext.getPlace().toLowerCase().contains(text) )
                proBonT.add(pdtext);
        }
        return proBonT;
    }

    public List<Product> getProductBasedOnPlace(String place) {
        List<Product> pdbs=new ArrayList<>();
        for(Product pd:products)
            if (pd.getPlace().equals(place) ){
                pdbs.add(pd);
        }
        return pdbs;
    }

    public List<Product> getProductBasedOnOutOfWarranty() {
        List<Product> pdbow=new ArrayList<>();
        for(Product pow:products)
            if (pow.getWarranty()<2023 ){
                pdbow.add(pow);
            }
        return pdbow;
    }
}
