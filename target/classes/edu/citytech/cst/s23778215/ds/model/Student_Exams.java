package edu.citytech.cst.s23778215.ds.model;

import edu.citytech.cst.s23778215.ds.BinarySearchTree;
import edu.citytech.cst.s23778215.ds.MapRecords;
import edu.citytech.cst.s23778215.ds.ResourceUtility;

import java.util.Arrays;
import java.util.List;

public class Student_Exams implements Comparable<Student_Exams> {

        private String id;
        private String gender;
        private Float exams[];

        public Student_Exams(String id, String gender, Float[] exams) {

                this.id = id;
                this.gender = gender;
                this.exams = exams;

        }

        public String getId() {
                return id;
        }

        public String getGender() {
                return gender;
        }

        public Float[] getExams() {
                return exams;
        }

        public Float getTotal() {
                Float total = 0f;
                for (Float payments : this.exams) {
                        total += payments;
                }

                return total;
        }

        public  Float getAvg(){
                float avg = 0;
                for (float i: exams){
                        avg+=i;
                }
                avg /=(float) exams.length;
                return avg;

        }
        public Float getSum(List<Student_Exams> list){
                float sum = 0;
                for (float i: Arrays.asList(getExams())){
                        sum+=i;
                }
                return sum;
        }

        public static void main(String[] args) {
                List<Student_Exams> student_examsList = ResourceUtility
                        .get("student-exams.json", 0, MapRecords::mapToJSON);
                //List<Sales> list = new LinkedList<>();
                BinarySearchTree<Student_Exams> bst = new BinarySearchTree<>();

                student_examsList.stream().sorted().forEach(bst::insert);

                //  Sales s = new Sales("B096",new Integer[]{127125,191835,182601,191432});

                System.out.println("Max: " + bst.max());

                System.out.println("\nMin: " + bst.min());

                System.out.println("\nSize: " + bst.size());

                //  System.out.println(bst.find(s));


        }


        @Override
        public String toString() {
                return "Student_Exams{" +
                        "id='" + id + '\'' +
                        ", gender='" + gender + '\'' +
                        ", exams=" + Arrays.toString(exams) +
                        "} total: "+ this.getTotal();
        }


        @Override
        public int compareTo(Student_Exams o) {
                return Float.compare(this.getAvg(), o.getAvg());
        }

}