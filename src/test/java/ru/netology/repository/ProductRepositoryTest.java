package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Book first = new Book(1, "The Master and Margarita", 100, "Mikhail Bulgakov");
    Book second = new Book(2, "Dead Souls", 110, "Nikolai Gogol");
    Smartphone third = new Smartphone(3, "Iphone 13", 120, "Apple");
    Smartphone fourth = new Smartphone(4, "Galaxy S21", 130, "Samsung");

    @Test
    public void shouldSaveItem() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdSmartrphone() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Smartphone expected = fourth;
        Product product = repository.findById(4);
        assertEquals(expected, product);
    }

    @Test
    public void shouldRemoveById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(1);

        Product[] expected = new Product[]{second, third, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIDBook() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Book expected = first;
        Product product = repository.findById(1);
        assertEquals(expected, product);


    }

    @Test
    public void shouldRemoveByNonExistentID() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Smartphone expexted = null;
        Product product = repository.findById(5);
        assertEquals(expexted, product);

    }
}