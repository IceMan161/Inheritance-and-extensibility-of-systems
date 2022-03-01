package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    private ProductManager manager = new ProductManager();
    private ProductRepository repository = new ProductRepository();


    Book first = new Book(1, "The Master and Margarita", 100, "Mikhail Bulgakov");
    Book second = new Book(2, "Dead Souls", 110, "Nikolai Gogol");
    Smartphone third = new Smartphone(3, "Iphone 13", 120, "Apple");
    Smartphone fourth = new Smartphone(4, "Galaxy S21", 130, "Samsung");

    @Test
    public void shouldAdd () {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Product[] expected = new Product[]{first,second,third,fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

//    @Test
//    public void shouldSearchBy() {
//        manager.add(first);
//        manager.add(second);
//        manager.add(third);
//        manager.add(fourth);
//
//        Product[] expected = new Product[]{third};
//        Product[] product = manager.searchBy("Iphone 13");
//        assertArrayEquals(expected, product);;
//    }
}