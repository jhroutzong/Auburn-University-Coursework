import java.util.NoSuchElementException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class BST {
    private int size = 0;
    private Node head;
    public int subDepth;
    public int sumHeight;
    public int averageHeight;



    protected class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        public Node(int i) {
            val = i;
        }
    }

    public BST() {

    }

    public BST(int i) {
        head = new Node(i);
        size = 1;
        //depth = 0;
        //levelNodes[0] = 1;
    }

    public int size() {
        return size;
    }

    public int addTrees() {

        sumHeight += subDepth;

        return sumHeight;
    }

    public int findAverage() {
        averageHeight = sumHeight / 7;
        return averageHeight;
    }

    public int length() {
        return size;
    }

    // get depth
    public int depth() {
        return getSubDepth(head);

    }

    // recursive method to get depth of any subtree
    private int getSubDepth(Node node) {
        if (node == null) return -1;
        //System.out.println("Current node: " + subBST.val);
        subDepth = 1 + (getSubDepth(node.left) >= getSubDepth(node.right)
                ? getSubDepth(node.left)
                : getSubDepth(node.right));
        return subDepth;
    }

    public void add(int newItem) {
        if (size == 0) {
            head = new Node(newItem);
        } else {
            //int level = 0; // the current level
            double d; // to be used to randomly choose left or right subtree
            Node current = head;
            Node newNode = new Node(newItem);
            while (current != null) {
                //level++; // level increased by one
                // go to left subtree if new item is less than current node key
                if (current.val > newItem) {
                    // add the node to its current left if current lefft is empty
                    if (current.left == null) {
                        current.left = newNode;
                        newNode.parent = current;
                        break;
                    }
                    // go to its left subtree
                    else
                        current = current.left;
                }
                // go to right subtree if new item is greater than current node key
                else if (current.val < newItem) {
                    if (current.right == null) {
                        current.right = newNode;
                        newNode.parent = current;
                        break;
                    } else
                        current = current.right;
                }
                // when new item is the same as the current node key
                else {
                    // add to its left subtree of current left subtree is empty
                    if (current.left == null) {
                        current.left = newNode;
                        newNode.parent = current;
                        break;
                    }
                    // add to its right subtree of current right subtree is empty
                    else if (current.right == null) {
                        current.right = newNode;
                        newNode.parent = current;
                        break;
                    }
                    // when neither left or right subtree is empty, randomly choose left or right subtree
                    else {
                        d = Math.random();
                        //System.out.println("current node's key = new item; randomly choose " + (d>0.5 ? "left":"right") );
                        current = (d > 0.5) ? current.left : current.right;
                    }
                }
            }

            //System.out.println(newItem + " added at level " + level);
        }

        size++;
    }
    }

