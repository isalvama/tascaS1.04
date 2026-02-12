package first_level.exercise1;

import java.util.*;
import static java.util.List.copyOf;


public class BooksCollection{
    private String name;
    private ArrayList<Book> bookArrayList;

    public BooksCollection(String name){
        this.name = name;
        this.bookArrayList = new ArrayList<>();
    }

    // Add a book to the collection
    public void addBook(Book b){
       if(!bookArrayList.contains(b))
        bookArrayList.add(b);
    }

    // Add multiple books to the collection
    public void addMultipleBooks(Collection<Book> b){
        bookArrayList.addAll(b);
    }

    // Affect a book in a specific position in the collection.
    public void addBookInPosition(int index, Book b){
        bookArrayList.add(index, b);
    }

    // Recover the complete list of books (following the insertion order).
    public List<Book> getBookArrayList() {
        return copyOf(bookArrayList);
    }

    // Obtain the title of a book from its position.
    public String getTitleFromPosition(int index){
        return bookArrayList.get(index).getTitle();
    }

    // Delete a book from its title.
    public void removeBookByTitle(String title){
        for (int i = 0; i < bookArrayList.size(); i++){
            if (title.equals(bookArrayList.get(i).getTitle())){
                bookArrayList.remove(i);
            }
        }
    }

    // Return a copy of the list in alphabetical order.
    public List<Book> getOrderedCollection(){
        ArrayList<Book> listCopy = new ArrayList<>(bookArrayList);
          Collections.sort(listCopy, new NameComparator());
        return listCopy;
    }
}
