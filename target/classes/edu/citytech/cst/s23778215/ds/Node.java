package edu.citytech.cst.s23778215.ds;

class Node<T extends Comparable<T>> {
    T value;


    Node<T> leftChild;
    Node<T> rightChild;
    Node(T value){ this.value=value; }
    int height;
//    Node(int data){
//         this.data = data;
//         leftChild = null;
//         rightChild = null;
//    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                " ,height=" + height +
                '}';
    }
}
