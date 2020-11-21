/*
 * Binary search tree data structure
 * @author : Angela Richards
 */

import java.util.ArrayList;

// extends comparable to use the compareTo function
public class BST<T extends Comparable<T>>
{
    /*
     * The root of the BST
     */
    Node<T> root;

    /*
     * Node class for a BST
     */
    private class Node<T>
    {
        Comparable<T> data; // value contained
        Node<T> left; // node
        Node<T> right; // pointer
        int instance; //

        Node(Comparable<T> item)
        {
            data = item;
            instance = 1;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    public BST()
    {
        root = null;
    }

    /*
     * Find function that finds an item in the BST
     * @param item to be found
     * @return boolean if the item was found
     */
    public boolean find(Comparable<T> item)
    {
        return find(item, root);
    }

    /*
     * Function override of the find function
     * @param item to be found
     * @param node the current node you are at
     * @return boolean if the item was found
     */
    private boolean find(Comparable<T> item, Node<T> node)
    {
        if(node == null){
            return false;
        }
        if(node.data.compareTo((T) item) == 0){
            return true;
        }
        else if(node.data.compareTo((T) item) > 0){
            return find(item, node.left);
        }
        else{
            return find(item, node.right);
        }
    }

    /*
     * Insert an item to the tree
     * @param item to insert
     */
    public void insert(Comparable<T> item)
    {
        root = insert(item, root);
    }

    /*
     * Helper function for insert
     * @param item to add
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> insert(Comparable<T> item, Node<T> node)
    {
        if(node == null){
            return new Node(item);
        }
        else if(node.data.compareTo((T) item) < 0){
            node.left = insert(item, node.left);
        }
        else if(node.data.compareTo((T) item) > 0){
            node.right = insert(item, node.right);
        }
        else{
            return node;
        }
        return node;
    }

    /*
     * Function for deletion of a node
     * @param item to delete
     */
    public void delete(Comparable<T> item)
    {
        root = delete(item, root);
    }

    /*
     * Helper function for deletion of a node
     * @param item to delete
     * @param node you are at
     * @return node you traverse to
     */
    private Node<T> delete(Comparable<T> item, Node<T> node)
    {
        if(node == null){
            return null;
        }
        if(node.data.compareTo((T) item) > 0){
            node.left = delete(item, node.left);
            return node;
        }
        else if(node.data.compareTo((T) item) < 0){
            node.right = delete(item, node.right);
            return node;
        }
        else{
            if(node.left == null){
                node.data = node.right.data;
            }
            else {
                node.data = removeSmallest(node.right.left);
            }
            return node;
        }
    }

    T removeSmallest(Node node){
        if(node.left.left == null){
            T small = (T) node.left.data;
            node.left = node.left.right;
            return small;
        }
        else{
            return(T) removeSmallest(node.left);
        }
    }

    public void rangeSum(Node<T> node, int L, int R, ArrayList<Integer> List){
        // so check if null first --> return 0
        // if not, go to the left most item (smallest) and add to root
        if (node != null) {
            // if the left is >= 0 and the right is <= 0
            if(node.data.compareTo((T) (Object) L) >= 0 && node.data.compareTo((T) (Object) R) <= 0){
                int sum = Integer.parseInt(node.data.toString());
                List.add(sum);
            }
            if(node.data.compareTo((T) (Object) L) > 0){
                rangeSum(node.left, L, R, List);
            }
            if(node.data.compareTo((T) (Object) R) < 0){
                rangeSum(node.right, L, R, List);
            }
        }
        else{
            // This would return an int, but java is making me return void
        }
    }

    /*
     * Function to find the range sum of the binary tree
     * @param L the left bound
     * @param R the right bound
     * @return The sum of the range in the binary tree
     */
    public int rangeSum(int L, int R)
    {
        int sum = 0;
        ArrayList<Integer> range = new ArrayList<>();
        rangeSum(root, L, R, range);

        for(int i : range){
            sum += i;
        }

        return sum;
    }

    /*
     * Function to print the Binary tree
     */
    public void print()
    {
        print(root);
    }

    /*
     * Helper Function to print the Binary tree
     * @param root the root of the tree
     */
    private void print(Node<T> root)
    {
        if(root != null){
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }

    @Override
    public String toString(){
        if(this.root == null){
            return "Tree is Empty";
        }
        return toString(this.root);
    }

    private String toString(Node root){
        String str = "";

        str += root.data;

        if(root.left != null){
            str += "(" + toString(root.left);
            str += ")";
        }

        if(root.right != null){
            str += "[" + toString(root.right);
            str += "]";
        }
        return str;
    }
}
