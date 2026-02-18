package first_level.exercise1;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class BooksCollectionTest {
    BooksCollection bc;
    Book book1;
    Book book2;
    Book book3;
    Book book4;
    Book book5;

    @BeforeEach
    public void setUp() {
         bc = new BooksCollection("Classics");
         book1 = new Book("Harry Potter", "J.K.Rowling");
         book2 = new Book("Pride And Prejudice", "Jane Austen");
         book3 = new Book("To Kill a Mockingbird", "Harper Lee");
         book4 = new Book("One Hundred Years Of Solitude", "Gabriel García Márquez");
         book5 = new Book("Jane Eyre", "Charlotte Bronte");
    }

    @AfterEach
    void teardown() {
        bc.removeAllBooks();
    }

    @DisplayName ("The collection should be empty after calling removeAllBook()")
    @Test
    void callingRemoveAllBooksCollection_bookArrayListIsNull() {
        bc.addMultipleBooks(new ArrayList<>(List.of(book1, book2, book3, book4, book5)));
        bc.removeAllBooks();
        Assertions.assertTrue(bc.getBookArrayList().isEmpty());
    }

    @DisplayName ("The collection should not be null after instancing the class")
    @Test
    void instanceBooksCollection_bookArrayListIsNotNull() {
        Assertions.assertNotNull(bc.getBookArrayList());
    }

    @DisplayName ("The collection's size is correct after adding a few books")
    @Test
    void addBook_validateBookArrayListSize() {
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        Assertions.assertEquals(3, bc.getBookArrayList().size());
    }

    @DisplayName ("The books are expected to be in the correct index after having added them in the collection")
    @Test
    void addBook_IndexCorrectOrder() {
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
        bc.addMultipleBooks(new ArrayList<>(Arrays.asList(book1, book2, book3)));
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
        bc.addMultipleBooks(new ArrayList<>(Arrays.asList(book1, book2, book3, book4, book5)));
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
        bc.addMultipleBooks(new ArrayList<>(Arrays.asList(book1, book2, book3, book4)));
        bc.removeBookByTitle("Pride And Prejudice");
        Assertions.assertEquals(3, bc.getBookArrayList().size());
        bc.removeBookByTitle("Harry Potter");
        Assertions.assertEquals(2, bc.getBookArrayList().size());
    }

    @DisplayName("The ordered list returns the books in alphabetic order without modifying the original collection")
    @Test
    void getOrderedCollection_returnsListInAlphabeticOrder() {
        bc.addBook(book1);
        bc.addBook(book2);
        bc.addBook(book3);
        bc.addBook(book4);
        bc.addBook(book5);
        Assertions.assertEquals("Harry Potter", bc.getOrderedBooksCollection().get(0).getTitle());
        Assertions.assertEquals("Jane Eyre", bc.getOrderedBooksCollection().get(1).getTitle());
        Assertions.assertEquals("One Hundred Years Of Solitude", bc.getOrderedBooksCollection().get(2).getTitle());
        Assertions.assertEquals("Pride And Prejudice", bc.getOrderedBooksCollection().get(3).getTitle());
        Assertions.assertEquals("To Kill a Mockingbird", bc.getOrderedBooksCollection().get(4).getTitle());
    }

    @DisplayName ("Books with duplicated titles cannot be added in the bookArrayList")
    @Test
    void addBook_DuplicatedTitleBookIsNotAdded() {
        Book book5 = new Book("Pride And Prejudice", "Charlotte Bronte"); //
        bc.addMultipleBooks(new ArrayList<>(Arrays.asList(book1, book2, book3, book4)));
        bc.addBook(book5);
        Assertions.assertEquals(4, bc.getBookArrayList().size());
    }
}