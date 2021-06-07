/**
 * definition of the BinarySearchTree class
 *
 *
 * @author Antonio Munoz
 * @version HW 6, #1
 * @bugs maybe the comparator is not implemented correctly
 */

package oop.amunoz.hw6.one;


import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree{

    /** node class
     *
     */
    private class Node{
        private Element data;
        private Node left;
        private Node right;

        /** constructor
         *
         * @param data Element part of the node
         * @param left left child of the node
         * @param right right child of the node
         */
        private Node(Element data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        /** fucntion that adds a node based on an element
         *
         * @param data value of the node
         * @return new node
         */
        private Node add(Element data){
            if (root == null){
                root = new Node(data, null, null);
                size++;
                return this;
            }
            else if (comparator.compare(this.data, data) <= 0 ){
                return left.add(data);
            }
            else {
                return right.add(data);
            }
        }

        /** function that finds if a value is in a node in the tree
         *
         * @param data value to be found
         * @return node that contains the value. NULL if its not found
         */
        private Node find(Element data){
            if (this == null){
                return this;
            }
            else{
                if (this.data == data){
                    return this;
                }
                else if (comparator.compare(this.data, data) <= 0){
                    return left.find(data);
                }
                else{
                    return right.find(data);
                }
            }

        }
    }

    private Node root;
    private int size;
    private Comparator<Element> comparator;

    /** constructor
     *
     * @param comparator to be used to sort the tree
     */
    public BinarySearchTree(Comparator<Element> comparator){
        root = null;
        size = 0;
        this.comparator = comparator;
    }

    /** function that adds a value to a tree
     *
     * @param data value to be added
     */
    public void add(Element data){
        if (root.add(data) != null){
            size++;
        }
    }

    /** function that finds a value in the tree
     *
     * @param data value to be found
     * @return true if its found, false otherwise
     */
    public boolean find(Element data){
        if (root.find(data) == null){
            return false;
        }
        else{
            return true;
        }
    }

    /** function that finds the minimum value in the tree
     *
     * @return value found
     */
    public Element findMin(){
        Node node = root;
        if (node == null){
            return null;
        }
        else if (node.left == null ){
            return node.data;
        }
        else{
            return findMin();
        }
    }

    /** function that finds the maximum vlaue in the tree
     *
     * @return value found
     */
    public Element findMax(){
        Node node = root;
        if (node == null){
            return null;
        }
        else if (node.right == null ){
            return node.data;
        }
        else{
            return findMax();
        }
    }

    /** function that tells if the tree is empty
     *
     * @return true if tree is empty, false otherwise
     */
    public boolean isEmpty(){
        if (root == null){
            return true;
        }
        else{
            return false;
        }
    }

    /** function that removes a value from the tree
     *
     * @param data value to be removed
     */
    public void remove(Element data){
        Node cur = root;
        Node prev = null;
        //taking under consideration all possibilities
        if ( cur.data==data && size == 1){
            root = null;
            size--;
        }
        while (cur!=null){
            if (cur.data == data) {
                if ( cur.left != null && cur.right == null){
                    if (prev.left == cur){
                        prev.left = cur.left;
                        cur = cur.left;
                    }
                    else{
                        prev.right = cur.left;
                        cur = cur.left;
                    }
                    size--;
                }
                else if ( cur.left == null && cur.right != null ){
                    if (prev.left == cur){
                        prev.left = cur.right;
                        cur = cur.right;
                    }
                    else{
                        prev.right = cur.right;
                        cur = cur.right;
                    }
                    size--;
                }
                else if ( cur.left == null && cur.right == null){
                    if(prev.left == cur){
                        prev.left = null;
                    }
                    else{
                        prev.right = null;
                    }
                    size--;
                }
                else{
                    Node max = cur.left;
                    Node temp = cur;
                    while (max.right != null){
                        temp = max;
                        max = max.right;
                    }
                    if ( prev.right == cur){
                        prev.right = max;
                    }
                    else{
                        prev.left = max;
                    }
                    max.left = cur.left;
                    temp.right = null;
                    size--;
                }
            } else if (comparator.compare(cur.data, data) < 0) {
                prev = cur;
                cur = cur.left;
            } else {
                prev = cur;
                cur = cur.right;
            }
        }
    }

    /** function that clears the tree,  easy approach
     *
     */
    public void clear(){

        root.left=null;
        root.right=null;
        root=null;
        size=0;

    }

    /** function that adds a sequence of elements
     *
     * @param toAdd array of elements
     */
    public void addAll(ArrayList<Element> toAdd){

        for(int i=0; i<toAdd.size();i++ ) {
            add(toAdd.get(i));
        }
    }

    /** function that prints the whole tree
     *
     * @param T enumeration value to tell which way to print the tree
     */
    public void print(Traversal T){
        if(T == Traversal.INORDER){
            System.out.println(inOrder(root));
        }
        if(T == Traversal.POSTORDER){
            System.out.println(postOrder(root));
        }
        if(T == Traversal.PREORDER){
            System.out.println(preOrder(root));
        }
    }

    /** function that prints the tree INORDER
     *
     * @param head root node
     * @return string to be printed
     */
    private String inOrder(Node head){

        if (head == null){
            return "";
        }
        return inOrder(head.left) + " " + head.data + " " + inOrder(head.right);

    }

    /** function that prints the tree POSTORDER
     *
     * @param head root node
     * @return string to be printed
     */
    private String postOrder(Node head){

        if (head == null){
            return "";
        }
        return postOrder(head.left) + " " + postOrder(head.right) + " " + head.data ;

    }

    /** function that prints the tree PREORDER
     *
     * @param head root node
     * @return string to be printed
     */
    private String preOrder(Node head){

        if (head == null){
            return "";
        }
        return head.data + " " + preOrder(head.left) + " " +  preOrder(head.right);

    }

}
