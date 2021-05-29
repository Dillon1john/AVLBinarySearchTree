package edu.citytech.cst.s23778215.ds;

import edu.citytech.cst.bst.cst3650.IBinarySeachTree;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

//public class BinarySearchTree<T extends Comparable<T>> {
public class BinarySearchTree<T extends Comparable<T>>  implements IBinarySeachTree<T>{
     Node<T> root;
    private int size;
    private Consumer<T> consumer = e -> {
    };
    //Consumer allows object to print itself or perform other functions
    private int sum;

    public BinarySearchTree() { }

//    protected Node<T> getRoot(){
//        return this.root;
//
//    }

    public BinarySearchTree(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void insert(T value) {
        size++;
        root = insert(root, value);

    }

    protected Node<T> insert(Node<T> current, T value) {

        if (current == null)
            return new Node(value);
        //Less than Logic
        if (value.compareTo(current.value) < 0)
            current.leftChild = insert(current.leftChild, value);
            //Greater than logic
        else if (value.compareTo(current.value) > 0)
            current.rightChild = insert(current.rightChild, value);
        else {
            --size;
            return current;
        }
        return current;
    }


    public T min() {
        return min(root);
    }

    protected T min(Node<T> root) {
        return root.leftChild == null ? root.value : min(root.leftChild);
    }

    public T max() {
        return max(root);
    }

    protected T max(Node<T> root) {
        return root.rightChild == null ? root.value : max(root.rightChild);
    }

    public int size() {
        return size;
    }




    public List<T> toList() {
        var list = new LinkedList<T>();
        traverseInOrder(root, list);
        return list;

    }

    protected void traverseInOrder(Node<T> node, List<T> list) {
        if (node != null) {
            traverseInOrder(node.leftChild, list);
            list.add(node.value);
            traverseInOrder(node.rightChild, list);
        }
    }

//    public double sum() {
//        // double v = sum(root.leftChild + sum(root.rightChild));
//        return 0;
//    }
//
//    protected double sum(Node<T> root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.leftChild == null && root.rightChild == null)
//            sum += root.data;
//
//        sum(root.leftChild);
//        sum(root.rightChild);
//
//        return 0;
//    }
}