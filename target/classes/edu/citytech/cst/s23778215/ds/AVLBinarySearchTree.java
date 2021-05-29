package edu.citytech.cst.s23778215.ds;


import edu.citytech.cst.bst.cst3650.IValue;
import edu.citytech.cst.bst.cst3650.Operator;
import edu.citytech.cst.bst.cst3650.model.MessageType;
import edu.citytech.cst.bst.cst3650.model.Pair;
import edu.citytech.cst.bst.cst3650.model.Triple;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AVLBinarySearchTree <T extends Comparable <T>> extends AdvancedBinarySearchTree<T> {
    boolean handleDuplicate = false;
    public void insert(T value){
        if(handleDuplicate)
//        var root = this.getRoot();
            root = create(root, value);
        else
        {
            // check duplicated key
            T node = find(value);
            if(node == null )   // no duplicated key
                root = create(root, value);
        }

    }


    private Node<T> create(Node<T> currentNode, T value){
        if (currentNode == null){
            return new Node<T>(value);
        }
        //less than
        if (value.compareTo(currentNode.value) < 0){
            currentNode.leftChild = create(currentNode.leftChild, value);
        }
        else //greater than
            currentNode.rightChild = create(currentNode.rightChild, value);



        updateHeight(currentNode);


        return updateBalance(currentNode);

    }

    protected Node<T> updateBalance(Node<T> currentNode){
        if (isLeftHeavy(currentNode)) {
            //System.out.println(currentNode + " is left heavy");
            if (balanceFactor(currentNode.leftChild) < 0){
                currentNode.leftChild=rotateLeft(currentNode.leftChild);

            }
           // System.out.println(currentNode.value+ " rotate to the right");
            return rotateRight(currentNode);
        }
        else if ( isRighttHeavy(currentNode)){
       //     System.out.println(currentNode+ " is right heavy");
            if (balanceFactor(currentNode.rightChild) > 0){

                currentNode.rightChild = rotateRight(currentNode.rightChild);

            }

            return rotateLeft(currentNode);
        }

        return currentNode;

    }
    protected Node<T> rotateRight(Node<T> currentNode){
        var newRoot = currentNode.leftChild;
        currentNode.leftChild = newRoot.rightChild;
        newRoot.rightChild = currentNode;

        updateHeight(currentNode);
        updateHeight(newRoot);

        return newRoot;
    }

    protected Node<T> rotateLeft(Node<T> root){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        updateHeight(root);
        updateHeight(newRoot);

        return newRoot;
    }

    protected void updateHeight(Node<T> currentNode){
        int left = height(currentNode.leftChild);
        int right = height(currentNode.rightChild);

        currentNode.height = Math.max(left,right)+1;

    }

    private int height(Node<T> node){
        if (node == null){
            return -1;
        }
        return node.height;
    }

    private boolean isLeftHeavy(Node<T> node){
        return height(node.leftChild) - height(node.rightChild) > 1;
    }

    private boolean isRighttHeavy(Node<T> node){
        return height(node.leftChild) - height(node.rightChild) < -1;
    }

    private int balanceFactor(Node<T> node){
        return height(node.leftChild) - height(node.rightChild);
    }


@Override
public T find(T value){

return find(value, noConsumer->{});
}
    @Override
    public T find(T value, Consumer<Triple<MessageType,T, Integer>> consumer) {
        var currentNode = root;
        boolean valueExists = false;

        while (currentNode != null){
            var triple = new Triple<>(MessageType.NODE,currentNode.value,currentNode.height);
            consumer.accept(triple);
            if(value.compareTo(currentNode.value)==0){
                valueExists=true;
                consumer.accept(triple);

                return currentNode.value;
            }
            else if (value.compareTo(currentNode.value)<0){
                currentNode = currentNode.leftChild;
                consumer.accept(triple);
            }
            else if (value.compareTo(currentNode.value)>0){
                currentNode= currentNode.rightChild;
                consumer.accept(triple);
            }


            }


        return null;
    }


    protected int counNodes(Node<Float> root)
    {
        Node<Float> current, pre;

        // Initialise count of nodes as 0
        int count = 0;

        if (root == null)
            return count;

        current = root;
        while (current != null)
        {
            if (current.leftChild == null)
            {
                // Count node if its left is NULL
                count++;

                // Move to its right
                current = current.rightChild;
            }
            else
            {
                /* Find the inorder predecessor of current */
                pre = current.leftChild;

                while (pre.rightChild != null && pre.rightChild != current)
                    pre = pre.rightChild;

            /* Make current as right child of its
            inorder predecessor */
                if(pre.rightChild == null)
                {
                    pre.rightChild = current;
                    current = current.leftChild;
                }

            /* Revert the changes made in if part to
            restore the original tree i.e., fix
            the right child of predecssor */
                else
                {
                    pre.rightChild = null;

                    // Increment count if the current
                    // node is to be visited
                    count++;
                    current = current.rightChild;
                }
            }
        }

        return count;
    }



    @Override
    public double median() {
        Node<Float> current = (Node<Float>) root, pre = null, prev = null;
        int count = counNodes(current);
        int currentCount = 0;

        while (current != null){
            if (current.leftChild == null){

                currentCount++;
                //Below checks if current node is median

                //odd
                if (count%2 != 0 && currentCount == (count+1)/2){
                    assert prev != null;
                    return prev.value;
                }
                //even
                else if (count %2 == 0 && currentCount == (count/2)+1){
                    return ( prev.value +  current.value) / 2;
                }
                //Updates prev for even # of nodes
                prev = current;
                //Moves current to the right
                current=current.rightChild;

            }
            else {
                //Finds predecessor of current
                pre = current.leftChild;
                while ((pre.rightChild != null && pre.rightChild != current)){
                    pre = pre.rightChild;
                }
                //Makes current right child of in order predecessor
                if (pre.rightChild == null){
                    pre.rightChild= current;
                    current = current.leftChild;
                }

                //Reverts changes to restorre the original tree
                else{
                    pre.rightChild = null;
                    prev=pre;

                    currentCount++;

                    //Checks currentnode for median
                    if (count%2 != 0 && currentCount == (count+1)/2){
                        return  current.value;
                    }
                    else if (count%2 == 0 && currentCount == (count/2)+1){
                        return  (prev.value+current.value)/2;
                    }
                    prev=current;
                    current=current.rightChild;
                }
            }
        }
        return -1;
        //return super.median();
    }

    @Override
    public Pair<T, T> medianPair() {
        T x,y;
        var currentNode = root;
        var list = new ArrayList<T>();
        traverseInOrder(currentNode,list);
        //If tree count even
        if(list.size()%2 == 0){
            x = list.get((list.size())/2-1);
            y = list.get((list.size())/2);
        }
        //If odd
        else{
            x = list.get((list.size())/2);
            y = x;

        }
        var ans = new Pair<T,T>(x,y);

        return  ans;

        //return super.medianPair();
    }

    @Override
    public double max(Consumer<Triple<MessageType, T, Integer>> consumer) {

        var currentNode = root;
        while (currentNode != null){
            var triple = new Triple<>(MessageType.NODE,(T)currentNode.value,currentNode.height);
            consumer.accept(triple);
            if (currentNode.rightChild == null){
                currentNode = (Node<T>) currentNode.value;
                consumer.accept(triple);
                return (Double) currentNode.value;
            }
            else {
                currentNode =  currentNode.rightChild;
                //consumer.accept(triple);
            }
//
        }
        return super.max(consumer);
    }

    @Override
    public double min(Consumer<Triple<MessageType, T, Integer>> consumer) {
        var currentNode = root;
        while (currentNode != null){
            var triple = new Triple<>(MessageType.NODE,(T)currentNode.value,currentNode.height);
            consumer.accept(triple);
            if (currentNode.leftChild == null){
                currentNode = (Node<T>) currentNode.value;
                consumer.accept(triple);
                return (Double) currentNode.value;
            }
            else {
                currentNode =  currentNode.leftChild;
                //consumer.accept(triple);
            }
//
        }

        return super.min(consumer);
    }

    @Override
    public List<T> where(Operator operator, T value) {
       return where(operator, value,noConsumer->{});
    }

    @Override
    public List<T> where(Operator operator, T value, Consumer<T> consumer) {
        var currentNode = root;
        var item = currentNode.value;
        List<T> list = new ArrayList<>();
        traverseInOrder(currentNode,list);
       // System.out.println(list);
       // consumer.accept(currentNode.value);

        if (operator == Operator.$EQ || operator == Operator.EQUAL_TO){
            list = list.stream().filter(e-> e.compareTo(value)==0).collect(Collectors.toList());
            list.forEach(consumer::accept);
            //.forEach(consumer::accept);
           // consumer.accept(currentNode.value);
            return list;

        }
        if (operator == Operator.$GT || operator == Operator.GREATER_THAN){
            list = list.stream().filter(e-> e.compareTo(value)>0).collect(Collectors.toList());
            list.forEach(consumer::accept);
            return list;

        }
        if (operator == Operator.$GTE || operator == Operator.GREATER_THAN_OR_EQUAL_TO){
            list = list.stream().filter(e-> e.compareTo(value)>=0).collect(Collectors.toList());
            list.forEach(consumer::accept);
            return list;

        }
        if (operator == Operator.$LT || operator == Operator.LESS_THAN){
            list = list.stream().filter(e-> e.compareTo(value)<0).collect(Collectors.toList());
            list.forEach(consumer::accept);
            //consumer.accept(currentNode.value);
            return list;

        }
        if (operator == Operator.$LTE || operator == Operator.LESS_THAN_OR_EQUAL_TO){
            list = list.stream().filter(e-> e.compareTo(value)<=0).collect(Collectors.toList());
            list.forEach(consumer::accept);
            return list;

        }
        if (operator == Operator.$NE || operator == Operator.NOT_EQUAL_TO){
            list = list.stream().filter(e-> e.compareTo(value)!=0).collect(Collectors.toList());
            list.forEach(consumer::accept);
            return list;

        }

        return super.where(operator, value, consumer);
    }

    @Override
    public List<T> top10() {

        var currentNode = root;
        var list = new ArrayList<T>();
        traverseInOrder(currentNode,list);
        var topTen = list.stream().sorted((x,y)-> y.compareTo(x)).limit(10).collect(Collectors.toList());
        return topTen;

            //list = list.stream().;

        //return super.top10();
    }

    @Override
    public double avg() {
        var list = new ArrayList<T>();
        traverseInOrder(root,list);
        double sum = 0;
        for (var item: list){
            if (item instanceof IValue){
                sum += ((IValue)item).getValue();
            }
            else if (item instanceof Number){
                sum += ((Number)item).doubleValue();
            }
        }

        //return super.avg();
        return sum/list.size();
    }

    @Override
    public void setHandleDuplicates(boolean handleDulicates) {
        this.handleDuplicate = handleDulicates;

//        super.setHandleDuplicates(handleDulicates);
    }
}









