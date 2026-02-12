package first_level.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static java.util.List.copyOf;

/*
V Afegir llibres a la col·lecció.
V Recuperar la llista completa de llibres (seguint l’ordre d’inserció).
V Obtenir el títol d’un llibre a partir de la seva posició.
V Afegir un llibre en una posició específica dins la col·lecció.
Eliminar un llibre pel seu títol.
Retornar una còpia de la llista ordenada alfabèticament.


V
Delete a book from its title.
Return a copy of the list in alphabetical order.
 */
public class BooksCollection implements Comparator<Book> {
    private String name;
    private ArrayList<Book> bookArrayList;

    public BooksCollection(String name){
        this.name = name;
        this.bookArrayList = new ArrayList<>();
    }

    // Add a book to the collection
    public void addBook(Book b){
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
        for(Book b : bookArrayList){
            if (title.equals(b.getTitle())){
                bookArrayList.remove(b);
            }
        }
    }

    // Return a copy of the list in alphabetical order.
//    public List<Book> getCollection(){
//
//        return copyOf(bookArrayList);
//    }


    @Override
    public int compare(Book book1, Book book2) {
        return 0;
    }
}
