package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductManager manager = new ProductManager(new ProductRepository());
    private Product first = new Product(1, "Name1", 10);
    private Book second = new Book(2, "Name2", 100, "Ivanov");
    private Smartphone third = new Smartphone(3, "Name3", 200, "Manufacturer");
    private Book fourth = new Book(4, "Name1", 120, "Petrov");
    private Book fifth = new Book(5, "Name4", 220, "Petrov1");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

    }

    @Test
    void shouldSearchByName() {
        Product[] expected = {first, fourth};
        assertArrayEquals(expected, manager.searchBy("Name1"));
    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = {second};
        assertArrayEquals(expected, manager.searchBy("Ivanov"));
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = {third};
        assertArrayEquals(expected, manager.searchBy("Manufacturer"));
    }

    @Test
    void shouldSearchByNotFound() {
        Product[] expected = new Product[0];
        assertArrayEquals(expected, manager.searchBy("Manufacturer1"));
    }

    @Test
    void shouldSearchByAuthor1() {
        Product[] expected = {fourth, fifth};
        assertArrayEquals(expected, manager.searchBy("Petrov"));
    }

}