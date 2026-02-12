package first_level.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BooksCollectionTest {
    //    Book book1 = new Book("Harry Potter", "J.K.Rowling");
//    Book book2 = new Book("Pride And Projudice", "Jane Austen");
//    Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
//    Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
//    Book book5 = new Book("Jane Eyre", "Charlotte Bronte");
//
//    BooksCollection bc = new BooksCollection("Classics");

    // The collection should not be null after instancing the class
    @Test
    void notNullInstance() {
        BooksCollection bc = new BooksCollection("Classics");
        Assertions.assertNotNull(bc);
    }

    // The collection's size is correct after adding a few books.
    @Test
    void validateArraySize() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Projudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        Assertions.assertEquals(3, bc.getBookArrayList().size());
    }

    // The books are expected to be in the correct index after having added them in the collection
// Adding a book in a specific position modifies the collection correctly.
    @Test
    void validateIndexInArray() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Projudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
        Book book5 = new Book("Jane Eyre", "Charlotte Bronte");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        Assertions.assertEquals(book3, bc.getBookArrayList().get(2));
        Assertions.assertEquals(book1, bc.getBookArrayList().get(0));
        bc.addBookInPosition(1, book4);
        Assertions.assertEquals(book4, bc.getBookArrayList().get(1));
        bc.addBookInPosition(0, book5);
        Assertions.assertEquals(book5, bc.getBookArrayList().get(0));
        Assertions.assertEquals(book1, bc.getBookArrayList().get(1));
    }

    //    El mètode per obtenir un llibre per posició retorna el títol correcte.
    @Test
    void getTitleByPosition() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Projudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
        Book book5 = new Book("Jane Eyre", "Charlotte Bronte");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        bc.addBook(book4);
        bc.addBook(book5);
        Assertions.assertEquals("Pride And Projudice", bc.getTitleFromPosition(1));
        Assertions.assertEquals("Harry Potter", bc.getTitleFromPosition(0));
        Assertions.assertEquals("One Hundred Years Of Solitude", bc.getTitleFromPosition(3));

    }

    //    Eliminar un llibre pel títol redueix la mida de la col·lecció.
    @Test
    void removeBookByTitle() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Prejudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
        Book book5 = new Book("Jane Eyre", "Charlotte Bronte");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        bc.addBook(book4);
        bc.removeBookByTitle("Pride And Prejudice");
        Assertions.assertEquals(3, bc.getBookArrayList().size());
        bc.removeBookByTitle("Harry Potter");
        Assertions.assertEquals(2, bc.getBookArrayList().size());

    }

    //    La llista ordenada retorna els llibres en ordre alfabètic (sense modificar la col·lecció original).
    @Test
    void getOrderedCollection() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Prejudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
        Book book5 = new Book("Jane Eyre", "Charlotte Bronte");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        bc.addBook(book4);
        bc.addBook(book5);
        Assertions.assertEquals("Jane Eyre", bc.getOrderedCollection().get(1).getTitle());
    }

    // No s’han de permetre llibres amb títols duplicats.
    @Test
    void addBook() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Prejudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
        Book book5 = new Book("Pride And Prejudice", "Charlotte Bronte");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        bc.addBook(book5);
        bc.addBook(book4);
        Assertions.assertEquals(4, bc.getBookArrayList().size());

    }
}