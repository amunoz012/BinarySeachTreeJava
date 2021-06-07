/**
 * definition of the Library class
 *
 *
 * @author Antonio Munoz
 * @version HW 6, #1
 * @bugs maybe the fact that the readfile function doesnt take a paramete. Instead it has hadcoded the file name
 */

package oop.amunoz.hw6.one;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> library;

    /** constructor
     *
     */
    public Library(){
        library = new ArrayList<Book>();
    }

    /** function that reads in the file
     *
     * @throws Exception in case file is not found
     */
    public void readFile() throws Exception {
        File file = new File("C:/Users/admin/IdeaProjects/Homework 6/src/oop/amunoz/hw6/one/library.txt");
        Scanner sc = new Scanner(file);

        //read lines and create books
        while (sc.hasNextLine()){
            String[] book = sc.nextLine().split(", ");
            //skip a line that is not necessary
            sc.nextLine();

            Book newBook = new Book(book[1], book[0], Integer.parseInt(book[2]) );
            library.add(newBook);
        }
    }

    /** function that prints all library
     *
     */
    public void print(){
        for ( int i = 0; i< library.size(); i++ ){
            library.get(i).print();
        }
    }

    /** function that returns a particular book
     *
     * @param index to get the book
     * @return book at index
     */
    public Book getBook(int index){
        return library.get(index);
    }

    /** funtion that returns the size of the library
     *
     * @return size of the library
     */
    public int size(){
        return library.size();
    }
}
