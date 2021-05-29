package edu.citytech.cst.s23778215.ds.model;

import edu.citytech.cst.s23778215.ds.BinarySearchTree;
import edu.citytech.cst.s23778215.ds.MapRecords;
import edu.citytech.cst.s23778215.ds.ResourceUtility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sales implements Comparable<Sales> {

    private String branch_id;
    private Integer quarters [];

    public Sales(String branch_id, Integer [] quarters){
        this.branch_id = branch_id;
        this.quarters = quarters;

    }
    public String getBranch_id() {
        return branch_id;
    }

    public Integer[] getQuarters() {
        return quarters;
    }

    public Integer getTotal(){
       Integer total = 0;
       for(Integer payments: quarters){
           total += payments;
       }

        return total;
    }

    public static void main(String[] args) {
//         List<Sales> textList = ResourceUtility
//            .get("2020.sales.csv",1, MapRecords::mapToText);
//        List<Sales> list = new LinkedList<>();
//        BinarySearchTree<Sales> bst = new BinarySearchTree<>(list::add);
//
//         textList.stream().sorted().forEach(bst::insert);
//
//         Sales s = new Sales("B096",new Integer[]{127125,191835,182601,191432});
//
//        System.out.println("Max: "+bst.max());
//
//        System.out.println("\nMin: "+bst.min());
//
//        System.out.println("\nSize: "+bst.size());
//
//       System.out.println(bst.find(s));
//

    }



    @Override
    public String toString() {
        return "Sales{" +
                "branch_id='" + branch_id + '\'' +
                ", quarters=" + Arrays.toString(quarters) +
                "}\n total: " +this.getTotal();
    }

    @Override
    public int compareTo(Sales o) {

        return Integer.compare(this.getTotal(),o.getTotal());
    }
}
