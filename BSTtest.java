/*
 * Main testing class for BST
 * @author: USFCACS 245
 */
public class BSTtest
{
    public static void main(String[] args)
    {
    //edited in favour of personal tests
        BST<Integer> mytest = new BST<Integer>();

        mytest.insert(4);
        mytest.insert(2);
        mytest.insert(0);
        mytest.insert(6);
        mytest.insert(9);
        mytest.insert(3);
        mytest.insert(1);
        mytest.insert(4);

        System.out.println(mytest.toString());
        System.out.println(mytest.rangeSum(0,9) + "\n");

        mytest.delete(3);
        mytest.print();
        System.out.println("\n" + mytest.toString());
        System.out.println(mytest.rangeSum(0, 9) + "\n");
    }
}
