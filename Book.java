/**
 * definition of the Book class
 *
 *
 * @author Antonio Munoz
 * @version HW 6, #1
 * @bugs maybe the fact that the comparator is not defined correctly
 */

package oop.amunoz.hw6.one;

import java.util.Comparator;

public class Book{

    private String name;
    private String author;
    private int year;

    /** constructor
     *
     * @param name book's name
     * @param author book's author
     * @param year book's year
     */
    public Book(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    /** function that prints out the book as a string
     *
     */
    public void print(){
        System.out.println(name + ", " + author + ", " + Integer.toString(year) );
    }

    /** function that returns the name of a book
     *
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /** function that return the author of a book
     *
     * @return author
     */
    public String getAuthor(){
        return this.author;
    }

    /** function that return the year of a book
     *
     * @return year
     */
    public int getYear(){
        return this.year;
    }

    /** implementation of the comparator by name
     *
     */
    public static class sortName implements Comparator<Book>{
        public int compare(Book a, Book b){
            return a.getName().compareTo(b.getName());
        }
    }

    /** implementation of the comparator by author
     *
     */
    public static class sortAuthor implements Comparator<Book> {
        public int compare(Book a, Book b){
            return a.getAuthor().compareTo(b.getAuthor());
        }
    }

    /** implementation of the comparator by year
     *
     */
    public static class sortYear implements Comparator<Book> {
        public int compare(Book a, Book b){
            return a.getYear()-b.getYear();
        }
    }
}