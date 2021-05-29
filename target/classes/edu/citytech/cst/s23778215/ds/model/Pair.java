package edu.citytech.cst.s23778215.ds.model;

public class Pair<T,U> {
	
	private final T t1;
	private final U t2;
	
	public Pair(T t1, U t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public T getT1() {
		return t1;
	}

	public U getT2() {
		return t2 ;
	}

	@Override
	public String toString() {
		return "Pair [t1=" + t1 + ", t2=" + t2 + "]";
	}
}