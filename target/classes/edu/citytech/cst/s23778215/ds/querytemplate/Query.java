package edu.citytech.cst.s23778215.ds.querytemplate;

public class Query {
    public <T extends Comparable<T>> boolean where(T value1, Operator operator, T value2) {
        boolean status = false;

        switch(operator){
            case $EQ:
                status = value1.compareTo(value2) == 0;
            case $LT:
                status = value1.compareTo(value2) < 0;
            case $LTE:
                status = value1.compareTo(value2) <= 0;
            case $GT:
                status = value1.compareTo(value2) > 0;
            case $GTE:
                status = value1.compareTo(value2) >= 0;
            case $NE:
                status = value1.compareTo(value2) != 0;
            default:
                break;

        }
        return status;

    }
}
