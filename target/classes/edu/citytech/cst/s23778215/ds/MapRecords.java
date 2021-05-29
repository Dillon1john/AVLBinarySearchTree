package edu.citytech.cst.s23778215.ds;

//import com.google.gson.Gson;

import com.google.gson.Gson;
import edu.citytech.cst.s23778215.ds.model.Sales;
import edu.citytech.cst.s23778215.ds.model.Student_Exams;

public class MapRecords {


    public static Sales mapToText(String row) {
        String[] columns = row.split("\\,");


        String branch_Id = columns[0];
        var q1 = Integer.parseInt(columns[1]);
        var q2 = Integer.parseInt(columns[2]);
        var q3 = Integer.parseInt(columns[3]);
        var q4 = Integer.parseInt(columns[4]);


        var sales = new Sales(branch_Id, new Integer[]{q1, q2, q3, q4});
        return sales;
    }
    private static Gson gson = new Gson();
    public static Student_Exams mapToJSON(String json) {

        Student_Exams se = gson.fromJson(json, Student_Exams.class);

        return se;

    }
}
