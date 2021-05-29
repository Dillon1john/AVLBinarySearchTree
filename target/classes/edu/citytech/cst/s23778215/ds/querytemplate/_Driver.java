package edu.citytech.cst.s23778215.ds.querytemplate;

import edu.citytech.cst.bst.cst3650.model.Pair;
import edu.citytech.cst.bst.cst3650.utility.AbstractFileLogic;
import edu.citytech.cst.s23778215.ds.BinarySearchTree;
import edu.citytech.cst.s23778215.ds.BusinessLogic;
import edu.citytech.cst.s23778215.ds.model.Student_Exams;

import java.lang.reflect.Constructor;

import static edu.citytech.cst.s23778215.ds.querytemplate.Operator.*;

public class _Driver {

//    public static void main(String[] args) {
////        boolean status = new Query().where(40f,$GT, 50f);
//
//        var car = new Asset("car",350_000f);
//        var house = new Asset("house",300_000f);
//        boolean status = new Query().where(400f,$GT, 50f);
//        status = new Query().where(car , $GT , house);
////        status = new Query().where("Z" , $GT , "A");
////        status = new Query().where(40f , $GT , 30f);
//        System.out.println("status: " + status);
//
//
//    }
public static void main(String[] args) throws Exception {

    e1();

    BinarySearchTree<Student_Exams> bst = new BinarySearchTree<>();

//    bst.avg();
    //bst.avg(Stock::getYield);






}

    @SuppressWarnings("unchecked")
    public static void e1() throws Exception {


        Class<AbstractFileLogic<Pair<String,Float>>> clazz  = (Class<AbstractFileLogic<Pair<String, Float>>>)
                Class.forName("edu.citytech.cst.s23778215.ds.BusinessLogic");

        Constructor<AbstractFileLogic<Pair<String,Float>>> ctor = clazz.getConstructor(String.class);

        BusinessLogic service = (BusinessLogic)ctor.newInstance("student-exams.json");
        var avg = service.getAverage();
        var max = service.getMax();
        var min = service.getMin();
        var sum = service.getSum();

        System.out.println("Avg: "+avg);
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        System.out.println("Sum: "+sum);

    }

    public static void e2() {

        var service = new BusinessLogic("student-exams.json");
        var avg = service.getAverage();
        var max = service.getMax();
        var min = service.getMin();
        var sum = service.getSum();

        System.out.println("Avg: "+avg);
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        System.out.println("Sum: "+sum);

    }
}
