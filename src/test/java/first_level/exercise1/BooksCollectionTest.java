package first_level.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BooksCollectionTest {

    // TODO TEST ADD MUTLIPLE BOOKS

    @DisplayName ("The collection should not be null after instancing the class")
    @Test
    void instanceBooksCollection_bookArrayListIsNotNull() {
        BooksCollection bc = new BooksCollection("Classics");
        Assertions.assertNotNull(bc.getBookArrayList());
    }

    @DisplayName ("The collection's size is correct after adding a few books")
    @Test
    void addBook_validateBookArrayListSize() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Projudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        Assertions.assertEquals(3, bc.getBookArrayList().size());
    }

    @DisplayName ("The books are expected to be in the correct index after having added them in the collection")
    @Test
    void addBook_IndexCorrectOrder() {
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

    @DisplayName ("Adding a book in a specific position modifies the collection correctly.")
    @Test
    void addBookInPosition_modificationIndexOfBooksInArray() {
        BooksCollection bc = new BooksCollection("Classics");
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("Pride And Projudice", "Jane Austen");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
        Book book5 = new Book("Jane Eyre", "Charlotte Bronte");
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        bc.addBookInPosition(1, book4);
        Assertions.assertEquals(book4, bc.getBookArrayList().get(1));
        bc.addBookInPosition(0, book5);
        Assertions.assertEquals(book5, bc.getBookArrayList().get(0));
        Assertions.assertEquals(book1, bc.getBookArrayList().get(1));
        Assertions.assertEquals(book2, bc.getBookArrayList().get(3));

    }

    @DisplayName ("The method getTitleFromPosition returns the correct title")
    @Test
    void getTitleByPosition_returnsTitleOfBookInPosition() {
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
        Assertions.assertEquals("Pride And Prejudice", bc.getTitleFromPosition(1));
        Assertions.assertNotEquals("Pride And Prejudice", bc.getTitleFromPosition(0));
        Assertions.assertEquals("Harry Potter", bc.getTitleFromPosition(0));
        Assertions.assertNotEquals("Harry Potter", bc.getTitleFromPosition(3));
        Assertions.assertEquals("One Hundred Years Of Solitude", bc.getTitleFromPosition(3));
        Assertions.assertNotEquals("One Hundred Years Of Solitude", bc.getTitleFromPosition(1));

    }

    @DisplayName("removeBookByTitle reduces the collection's size")
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

    @DisplayName("The ordered list returns the books in alphabetic order without modifying the original collection")
    @Test
    void getOrderedCollection_returnsListInAlphabeticOrder() {
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
        Assertions.assertEquals("Harry Potter", bc.getOrderedCollection().get(0).getTitle());
        Assertions.assertEquals("Jane Eyre", bc.getOrderedCollection().get(1).getTitle());
        Assertions.assertEquals("One Hundred Years Of Solitude", bc.getOrderedCollection().get(2).getTitle());
        Assertions.assertEquals("Pride And Prejudice", bc.getOrderedCollection().get(3).getTitle());
        Assertions.assertEquals("To Kill a Mockingbird", bc.getOrderedCollection().get(4).getTitle());


    }

    @DisplayName ("Books with duplicated titles cannot be added in the bookArrayList")
    @Test
    void addBook_DuplicatedTitleBookIsNotAdded() {
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