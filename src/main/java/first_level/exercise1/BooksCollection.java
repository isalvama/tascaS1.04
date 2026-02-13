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

    public void addBook(Book b){
       if(!bookArrayList.contains(b))
        bookArrayList.add(b);
    }

    public void addMultipleBooks(Collection<Book> b){
        bookArrayList.addAll(b);
    }

    public void addBookInPosition(int index, Book b){
        bookArrayList.add(index, b);
    }

    public List<Book> getBookArrayList() {
        return copyOf(bookArrayList);
    }

    public String getTitleFromPosition(int index){
        return bookArrayList.get(index).getTitle();
    }

    public void removeBookByTitle(String title){
        for (int i = 0; i < bookArrayList.size(); i++){
            if (title.equals(bookArrayList.get(i).getTitle())){
                bookArrayList.remove(i);
            }
        }
    }

    public List<Book> getOrderedCollection(){
        ArrayList<Book> listCopy = new ArrayList<>(bookArrayList);
          listCopy.sort(new NameComparator());
        return listCopy;
    }
}
