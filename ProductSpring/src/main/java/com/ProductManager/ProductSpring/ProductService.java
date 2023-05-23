package com.ProductManager.ProductSpring;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDB db;
//    public void addProduct(Product p){
//        db.save(p);
//        //products.add(p);
//    }

    public  List<Product> getAllProduct(){
        return  db.findAll();
        // return products;
    }
//    public Product getProduct(String name){
////        for(Product pd:products) {
////            if (pd.getName().equals(name) )
////                return pd;
////        }
//        // return null;
//        return db.getProduct(name);
//
//    }



//    public List<Product> getProductBasedOnText(String ptext){
//        List<Product> proBonT=new ArrayList<>();
//        String text=ptext.toLowerCase();
//        for(Product pdtext:products) {
//            if (pdtext.getName().toLowerCase().contains(text) || pdtext.getType().toLowerCase().contains(text) || pdtext.getPlace().toLowerCase().contains(text) )
//                proBonT.add(pdtext);
//        }
//        return proBonT;
//    }
//
//    public List<Product> getProductBasedOnPlace(String place) {
//        List<Product> pdbs=new ArrayList<>();
//        for(Product pd:products)
//            if (pd.getPlace().equals(place) ){
//                pdbs.add(pd);
//            }
//        return pdbs;
//    }
//
//    public List<Product> getProductBasedOnOutOfWarranty() {
//        List<Product> pdbow=new ArrayList<>();
//        for(Product pow:products)
//            if (pow.getWarranty()<2023 ){
//                pdbow.add(pow);
//            }
//        return pdbow;
//    }
}
