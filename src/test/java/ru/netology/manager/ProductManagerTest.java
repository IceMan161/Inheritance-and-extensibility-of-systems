package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);


    Book first = new Book(1, "The Master and Margarita", 100, "Mikhail Bulgakov");
    Book second = new Book(2, "Dead Souls", 110, "Nikolai Gogol");
    Smartphone third = new Smartphone(3, "Iphone 13", 120, "Apple");
    Smartphone fourth = new Smartphone(4, "Galaxy S21", 130, "Samsung");
    Smartphone fifth = new Smartphone(5, "Iphone 13", 120, "Apple");

    @BeforeEach
    public void initEach() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }


    @Test
    public void shouldAdd() {

        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBy() {

        Product[] expected = new Product[]{third};
        Product[] product = manager.searchBy("Iphone 13");
        assertArrayEquals(expected, product);

    }

    @Test
    public void shouldIfSeveralProductsAreSuitable() {

        manager.add(fifth);
        Product[] expected = new Product[]{third, fifth};
        Product[] product = manager.searchBy("Iphone 13");
        assertArrayEquals(expected, product);
    }

    @Test
    public void shouldNoneOfTheProductsAreSuitable() {
        Product[] expected = new Product[]{};
        Product[] product = manager.searchBy("Iphone 14");
        assertArrayEquals(expected, product);
    }
}