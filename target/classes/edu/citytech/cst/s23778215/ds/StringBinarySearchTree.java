package edu.citytech.cst.s23778215.ds;

import edu.citytech.cst.bst.cst3650.IStringBinarySeachTree;

import java.util.LinkedList;
import java.util.List;

public  class StringBinarySearchTree<T extends Comparable<T>>  implements IStringBinarySeachTree<T> {
    private Node<String> root;
    private int size;

    public void insert(String value) {
        size++;
        root = insert(root,  value);

    }

    @Override
    public String min(){ return min(root);}

    protected String min(Node <String> root){
        return root.leftChild == null ? root.value : min(root.leftChild);
    }


    @Override
    public String max() { return max(root); }

    protected String max(Node<String> root){
        return root.rightChild == null ? root.value : max(root.rightChild);
    }


    protected Node<String> insert(Node<String> current, String value){

        if (current == null)
            return new Node(value);
        //Less than Logic
        if (value.compareTo(current.value) < 0)
            current.leftChild = insert(current.leftChild,value);
            //Greater than logic
        else if (value.compareTo(current.value) > 0)
            current.rightChild = insert(current.rightChild,value);
        else{
            --size;
            return current;
        }
        return current;
    }


//    public String min(){ return min(root);}
//
//    protected String min(Node <String> root){
//        return root.leftChild == null ? root.value : min(root.leftChild);
//    }

//    public String max(){ return max(root); }
//
//    protected String max(Node<String> root){
//        return root.rightChild == null ? root.value : max(root.rightChild);
//    }

    public int size() {
        return size;
    }

    public List<String> toList(){
        var list = new LinkedList<String>();
        traverseInOrder(root,list);
        return list;

    }

    protected void traverseInOrder(Node<String> node,List<String> list){
        if (node != null){
            traverseInOrder(node.leftChild,list);
            list.add(node.value);
            traverseInOrder(node.rightChild,list);
        }
    }
}



