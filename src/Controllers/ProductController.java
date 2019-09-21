/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.ProductDao;
import Models.Product;
import java.util.ArrayList;

/**
 *
 * @author Michail Sitmalidis
 */
public class ProductController {

    ProductDao productDao;

    public ProductController() {
        productDao = new ProductDao();
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = productDao.getProducts();
        return products;
    }

    public Product getProductById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
