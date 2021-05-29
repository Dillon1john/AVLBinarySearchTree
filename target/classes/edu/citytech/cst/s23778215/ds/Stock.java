package edu.citytech.cst.s23778215.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stock  implements Comparable<Stock>{
    private String symbol;
    private double dividends[];

    public Stock(String symbol, double[] dividends){
        this.symbol = symbol;
        this.dividends = dividends;
    }

    public double getTotal(){
        double total = 0;
        for ( double payments : dividends){
            total += payments;

        }
        return total;

    }

    public static void main(String[] args) {
        // load data from file

        var ibm= new Stock("IBM", new double[]{10d,15d,13d,12d}); //Quarters - months etc
        var o = new Stock("O", new double[]{10d,15d,13d,12d,10d,15d,13d,12d,10d,15d,13d,12d});
        var msft = new Stock("MSFT", new double[]{1d,1d,3d,2d});

        Comparable<Stock> x = ibm;


        List<Comparable<Stock>> stocks = new ArrayList<>();

        stocks.add(ibm);
        stocks.add(msft);
        stocks.add(o);

//        Collections.sort(stocks);

        stocks.stream().sorted()
                .forEach(System.out::println);

        var results = ibm.compareTo(msft);
        System.out.println(results);

        //0 = equal to
        //1 = greater than
        // -1 = lesser than
    }


    @Override
    public int compareTo(Stock o) {
        //TODO Auto-generated method stub
        return Double.compare(this.getTotal(), o.getTotal());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", dividends=" + Arrays.toString(dividends) +
                "} total: "+this.getTotal();
    }
}
