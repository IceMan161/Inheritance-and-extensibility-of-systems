package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];
    private Product item;

    public ProductManager() {
    }

    public ProductManager(ProductRepository repository, Product[] items, Product item) {
        this.repository = repository;
        this.items = items;
        this.item = item;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                int length = items.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(items, 0, tmp, 0, items.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                items = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
