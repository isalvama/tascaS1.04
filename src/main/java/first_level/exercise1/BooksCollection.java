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

    public void addBook(Book book){
       if(!bookArrayList.contains(book))
        bookArrayList.add(book);
    }

    public void addMultipleBooks(Collection<Book> bookCollection){
        for(Book book : bookCollection)
            if(!bookArrayList.contains(book)){
                bookArrayList.add(book);
            }
    }

    public void addBookInPosition(int index, Book book){
        bookArrayList.add(index, book);
    }

    public List<Book> getBookArrayList() {
        return copyOf(bookArrayList);
    }

    public String getTitleFromPosition(int index){
        return bookArrayList.get(index).getTitle();
    }

    public void removeBookByTitle(String title){
        Iterator<Book> booksIterator = bookArrayList.iterator();
        while (booksIterator.hasNext()){
            if (booksIterator.next().getTitle().equals(title)){
                booksIterator.remove();
            }
        }
    }

    public List<Book> getOrderedBooksCollection(){
        List<Book> listCopy = new ArrayList<>(bookArrayList);
          listCopy.sort(new NameComparator());
        return listCopy;
    }

    public void removeAllBooks() {
        bookArrayList.clear();
    }
}
