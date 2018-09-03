package pl.springmvc.zadanie.springmvczadanie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/products")
    @ResponseBody
    public String showAll() {

        List<Product> products = repository.getProducts();

        String result = priceSum(products);

        return products.toString() + result;
    }

    @GetMapping("/food")
    @ResponseBody
    public String showFood() {

        List<Product> products = repository.getProducts();
        ArrayList<Product> foodProducts = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getCategory().equals(Category.FOOD.getCategoryName())) {
                foodProducts.add(new Product(products.get(i).getName(), products.get(i).getPrice(), products.get(i).getCategory()));
            }
        }
        String result = priceSum(foodProducts);

        return foodProducts.toString() + result;
    }

    @GetMapping("/clean")
    @ResponseBody
    public String showClean() {

        List<Product> products = repository.getProducts();
        ArrayList<Product> cleanProducts = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getCategory().equals(Category.CLEAN.getCategoryName())) {
                cleanProducts.add(new Product(products.get(i).getName(), products.get(i).getPrice(), products.get(i).getCategory()));
            }
        }
        String result = priceSum(cleanProducts);
        return cleanProducts.toString() + result;
    }

    @GetMapping("/other")
    @ResponseBody
    public String other() {

        List<Product> products = repository.getProducts();
        ArrayList<Product> otherProducts = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getCategory().equals(Category.OTHER.getCategoryName())) {
                otherProducts.add(new Product(products.get(i).getName(), products.get(i).getPrice(), products.get(i).getCategory()));

            }
        }
        String result = priceSum(otherProducts);
        return otherProducts.toString() + result;
    }

    @PostMapping("/add")
    public String add(@RequestParam String name,
                      @RequestParam double price,
                      @RequestParam String category) {
        Product product = new Product(name, price, category);
        repository.addProduct(product);

        return "redirect:/products";
    }

    public String priceSum(List<Product> products) {

        double result = 0;

        for (int i = 0; i < products.size(); i++) {
            result += products.get(i).getPrice();
        }

        String.valueOf(result);

        return "<br>" + result + " zł";
    }
}
