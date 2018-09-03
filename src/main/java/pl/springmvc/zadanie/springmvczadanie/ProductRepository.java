package pl.springmvc.zadanie.springmvczadanie;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("Masło", 4.50, Category.FOOD.getCategoryName()));
        products.add(new Product("Mydło", 7.99, Category.CLEAN.getCategoryName()));
        products.add(new Product("Sekator", 14.00, Category.OTHER.getCategoryName()));
        products.add(new Product("Czosnek", 1.40, Category.FOOD.getCategoryName()));
        products.add(new Product("Szampon", 20.99, Category.CLEAN.getCategoryName()));
        products.add(new Product("Doniczka", 9.40, Category.OTHER.getCategoryName()));
        products.add(new Product("Gazeta", 3.33, Category.OTHER.getCategoryName()));
        products.add(new Product("Udrażniacz rur", 4.50, Category.CLEAN.getCategoryName()));
        products.add(new Product("Ryż", 5.55, Category.FOOD.getCategoryName()));
        products.add(new Product("Płatki owsiane", 2.50, Category.FOOD.getCategoryName()));
        products.add(new Product("Odświeżacz powietrza", 7.80, Category.CLEAN.getCategoryName()));
        products.add(new Product("Tacki papierowe", 9.99, Category.OTHER.getCategoryName()));
    }

    public List<Product> getProducts() { return products; }

    public void addProduct(Product product){
        products.add(product);
    }


}
