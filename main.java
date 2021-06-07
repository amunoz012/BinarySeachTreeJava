/**
 * Program that sorts books by author. book name and year
 *
 *
 * @author Antonio Munoz
 * @version HW 6, #1
 * @bugs tried creating the tree using the comparator method created in the book class. I feel I'm sending the wrong
 *      parameters for the constructors
 */

package oop.amunoz.hw6.one;

public class main {

    public static void main(String args[]) throws Exception {
        Library lib = new Library();
        lib.readFile();
        //BinarySearchTree authors = new BinarySearchTree(Book.sortAuthor());
        //BinarySearchTree names = new BinarySearchTree(Book.sortName());
        //BinarySearchTree years = new BinarySearchTree(Book.sortYear());
        //I'm trying to send the comparator as an attribute for the tree as the PDF specifies but it is not working :(
    }
}
