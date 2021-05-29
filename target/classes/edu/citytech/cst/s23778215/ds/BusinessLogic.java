package edu.citytech.cst.s23778215.ds;

import edu.citytech.cst.bst.cst3650.model.Pair;
import edu.citytech.cst.bst.cst3650.sample.Stock;
import edu.citytech.cst.bst.cst3650.utility.AbstractFileLogic;
import edu.citytech.cst.s23778215.ds.model.Student_Exams;

import java.util.LinkedList;
import java.util.List;

public class BusinessLogic extends AbstractFileLogic<Pair<String, Float>> {

	static List<edu.citytech.cst.bst.cst3650.sample.Stock> list = new LinkedList<>();

	static BinarySearchTree<Student_Exams> bst = new BinarySearchTree<>();

	
	static {
		List<Student_Exams> student_examsList = ResourceUtility
				.get("student-exams.json",0,MapRecords::mapToJSON);

		student_examsList.stream().sorted().forEach(bst::insert);

		

		
	}
	
	
	public BusinessLogic(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pair<String, Float> getMax() {

		
		var data = bst.max();
		
		var answer  = new Pair<String,Float>(data.getId(), data.getAvg() );
		return answer ;
	}

	@Override
	public Pair<String, Float> getMin() {
		var data = bst.min();

		var answer  = new Pair<String,Float>(data.getId(), data.getAvg());
		return answer;
	}

	@Override
	public Pair<String, Float> getAverage() {
		var data = bst.toList().stream().mapToDouble(Student_Exams::getAvg).sum();
		var d = data/ bst.size();
		var answer  = new Pair<String,Float>(AVG, (float) d );
		return answer;
	}


	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return bst.size();
	}

	@Override
	public Pair<String, Float> getSum() {

		var data = bst.toList().stream().mapToDouble(Student_Exams::getTotal).sum();

		var answer  = new Pair<String,Float>(SUM, (float) data);
		return answer;	
	}
}
